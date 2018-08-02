package com.sguess.ctrl;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Controller
@EnableAutoConfiguration
public class LoginCtrl {
    @RequestMapping(value = "/login")
    public String logonPage(Model model) {
        model.addAttribute("loginTime", new Date().toString());
        return "login";
    }
}
