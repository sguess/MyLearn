package com.sguess.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
    @RequestMapping("/")
    public String pathRoot() {
        return "index";
    }

    @RequestMapping("a")
    public String patha() {
        return "pages/a";
    }

    @RequestMapping("/b")
    public String pathb() {
        return "pages/b";
    }
}