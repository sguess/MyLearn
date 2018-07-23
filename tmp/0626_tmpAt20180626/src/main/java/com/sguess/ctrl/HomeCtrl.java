package com.sguess.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }
}
