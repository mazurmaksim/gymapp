package org.crm.gymapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin-page";
    }

    @GetMapping("/userpage")
    public String userLogin() {
        return "user-page";
    }

    @GetMapping("/manager")
    public String managerLogin() {
        return "manager-page";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
}
