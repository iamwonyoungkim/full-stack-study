package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

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

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationErrorFilter authenticationErrorFilter;

    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;


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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 같은 문자열이어도 매번 다르게 암호화된다.
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // cross origin 접근 허용
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    // 접근 제한 무시 경로 설정 - resource
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 한글 인코딩 필터 설정
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                // 인증 에러 필터
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
                // jwt 인증 필터
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 로그인 인증 필터
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // 예외 처리 설정
        http
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http
                .authorizeRequests() // 경로별 접근 권한 설정
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api/security/all").permitAll() // 모두 허용
                .antMatchers("/api/security/member").access("hasRole('ROLE_MEMBER')") // ROLE_MEMBER 이상 접근 허용
                .antMatchers("/api/security/admin").access("hasRole('ROLE_ADMIN')") // ROLE_ADMIN 이상 접근 허용
                .anyRequest().authenticated(); // 나머지는 로그인 된 경우 모두 허용

        http.httpBasic().disable() // 기본 HTTP 인증 비활성화
                .csrf().disable() // CSRF 비활성화
                .formLogin().disable() // formLogin 비활성화 / 관련 필터 해제
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 생성 모드 설정
    }

    // Authentication Manager 구성
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
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
