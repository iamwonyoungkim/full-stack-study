package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j2
@RequestMapping("/security")
@Controller
public class SecurityController {

    @GetMapping("/all") // 모두 접근 가능
    public void doAll() {
        log.info("do all can access everybody");
    }

    @GetMapping("/member") // MEMBER 또는 ADMIN 권한 필요
    public void doMember(Authentication authentication) {
        // Principal을 주입하는 경우
//        log.info("username = " + principal.getName());

        // Authentication을 주입하는 경우
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("username = " + userDetails.getUsername());
    }

    @GetMapping("/admin") // ADMIN 권한 필요
    public void doAdmin(@AuthenticationPrincipal CustomUser customUser) {
        // @AuthenticationPrincipal 어노테이션을 이용하는 경우 - CustomUser 주입을 요구할 수 있음
        MemberVO member = customUser.getMember();
        log.info("username = " + member);
    }

    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}
