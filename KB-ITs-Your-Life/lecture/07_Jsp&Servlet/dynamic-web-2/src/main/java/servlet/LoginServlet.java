package servlet;

import domain.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // filter를 만들지 않았다면 아래의 인코딩 설정을 해줘야 한다.
        // req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String saveEmail = req.getParameter("saveEmail"); // checkbox에서 체크하면 on, 체크안하면 null이 들어간다.
        System.out.println(saveEmail); // 콘솔에서 저장되는 값 확인 가능

        // 이메일을 쿠키에 저장
        if(saveEmail != null) { // 이메일 저장 체크박스에 체크한 경우
            Cookie cookie = new Cookie("saveEmail", email); // 저장 여부가 아닌 실제 이메일인 email을 저장한다.
            cookie.setMaxAge(60*60*24); // 1일동안 쿠키 유지
            resp.addCookie(cookie);
        } else { // 체크 안한 경우 -> 쿠키 삭제
            Cookie cookie = new Cookie("saveEmail", "");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        // DB에서 회원 정보를 확인하는 코드가 여기 들어간다.
        boolean isValid = validateMember(email, password);

        if (isValid) {
            MemberVO member = MemberVO.builder()
                    .seq(1)
                    .email(email)
                    .name("홍길동")
                    .build();

            HttpSession session = req.getSession();
            session.setAttribute("member", member);
            // session이 아닌 request에 저장하면 !!절대!! 안된다. 안그러면 분명 로그인했는데 또 로그인하라는 경우가 생긴다..

            resp.sendRedirect("home");
        } else {
            resp.sendRedirect("login");
        }

    }

    private boolean validateMember(String email, String password) {
        // 실제로는 DB에 email과 password가 있는지 확인해야 한다.
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dis = req.getRequestDispatcher("login.jsp");
        dis.forward(req, resp);
    }
}
