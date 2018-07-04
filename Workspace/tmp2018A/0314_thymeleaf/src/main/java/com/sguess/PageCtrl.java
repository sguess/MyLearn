package com.sguess;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageCtrl {
    @RequestMapping(value = "/")
    public String homePage() {
        System.out.println("This is home page");
        return "homePage";
    }

    @RequestMapping(value = "/home")
    public String home() {
        System.out.println("This is home page");
        return "home";
    }

    @RequestMapping(value = "/signIn")
    public String homeNotSignedIn() {
        System.out.println("This is home page");
        return "homeNotSignedIn";
    }
}
