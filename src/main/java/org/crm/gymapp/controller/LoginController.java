package org.crm.gymapp.controller;

import org.crm.gymapp.dto.LoginDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String homePage() {
        return "login";
    }

    @GetMapping("/success")
    public String login() {
        return "success";
    }
}
