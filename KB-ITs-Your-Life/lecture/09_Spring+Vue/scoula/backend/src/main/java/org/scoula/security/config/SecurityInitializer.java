package org.scoula.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

// 필수. 아무 내용이 없더라도 꼭 만들어야 한다.
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    // 문자셋 필터
    private CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    // Spring Security 통과하기 전 선행 작업
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        insertFilters(servletContext, encodingFilter(), new MultipartFilter()); // servletContext -> 기준, 이후 2개 필터 -> 순서대로 제시
    }
}
