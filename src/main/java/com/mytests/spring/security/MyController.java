package com.mytests.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    @RequestMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("home_attr1", "home_attr1");
        return "home";
    }

    @RequestMapping("/secret")
    public String secret(ModelMap model) {
        model.addAttribute("secret_attr1", "secret_attr1");
        return "secret";
    }
}
