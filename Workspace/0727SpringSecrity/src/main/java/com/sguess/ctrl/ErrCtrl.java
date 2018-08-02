package com.sguess.ctrl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ErrCtrl {
    @RequestMapping(value = "/accessDenied")
    public String logonPage(Model model) {
        return "error/accessDenied";
    }
//    @RequestMapping(value = "/error")
//    public String pageNotFound(Model model) {
//        return "error/pageNotFound";
//    }
}
