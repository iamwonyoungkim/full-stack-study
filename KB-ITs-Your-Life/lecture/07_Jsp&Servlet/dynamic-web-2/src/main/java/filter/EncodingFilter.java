package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 요청에 대한 인코딩 설정
        servletRequest.setCharacterEncoding("UTF-8");
        // 다음 필터 또는 서블릿으로 요청 전달
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
