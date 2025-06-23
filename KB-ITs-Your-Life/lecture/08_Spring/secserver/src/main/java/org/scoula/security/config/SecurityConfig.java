package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
// Adapter -> 인터페이스의 메소드들을 모두 default 형태로 작성해놓은 것. (중간 역할)
// 이 Adapter를 이용해서 필요한 메서드만 override하면 깔끔하다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 같은 문자열이어도 매번 다르게 암호화된다.
    }

    // 문자셋 필터
    /*
    Spring Seurity 설정 후 POST 요청
    - 한글 문자 인코딩 발생
        - WebConfig에서 등록한 문자 인코딩 필터보다 먼저 Security Filter가 동작
        - Security Filter에서 POST body가 resolve됨 -> 한글 깨짐
    -> Spring Security Filter 체인에서 문자 인코딩 필터를 CsrfFilter보다 앞에 등록 필요.
     */
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                // 모두 허용
                .antMatchers("/security/all").permitAll()
                // 특정 역할에게만 허용
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')")
                // 로그인 사용자에게 허용
                .antMatchers("/board/write", "/board/modify", "/board/delete").authenticated();

//        http.formLogin(); // form 기반 로그인 활성화, 나머지는 모두 디폴트

        http.formLogin()
                .loginPage("/security/login")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/");

        http.logout() // 로그아웃 설정 시작
                .logoutUrl("/security/logout") // POST: 로그아웃 호출 url
                .invalidateHttpSession(true) // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure ...................................");

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

        // in memory user 정보 주석 처리 -> UserDetailsService와 같이 사용 불가
//        auth.inMemoryAuthentication()
//                .withUser("admin")
////                .password("{noop}1234") // noop: no operation의 약자. 아무것도 하지 말라는 뜻.
//                .password("$2a$10$pvUFA3WkWV4Kvw5/Rhdw1.5LxB2j12LYbxFArA4.jsDQteK02/H.q")
//                .roles("ADMIN", "MEMBER"); // ROLE_ADMIN
//
//        auth.inMemoryAuthentication()
//                .withUser("member")
////                .password("{noop}1234")
//                .password("$2a$10$pvUFA3WkWV4Kvw5/Rhdw1.5LxB2j12LYbxFArA4.jsDQteK02/H.q")
//                .roles("MEMBER"); // ROLE_MEMBER
    }
}
