package com.atsens.corespringsecurity.controller.login;

import com.atsens.corespringsecurity.domain.entity.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        @RequestParam(value = "expired", required = false) String expired, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        model.addAttribute("expired", expired);
        return "login";
    }

    @GetMapping({"/denied", "/api/denied"})
    public String accessDenied(@RequestParam(value = "exception", required = false) String exception, Model model) {
        // denied 페이지에는 현재 사용자 이름도 출력하고 권한이 없음을 표시한다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) authentication.getPrincipal();
        model.addAttribute("username", account.getUsername());
        model.addAttribute("exception", exception);

        return "user/login/denied";
    }
}
