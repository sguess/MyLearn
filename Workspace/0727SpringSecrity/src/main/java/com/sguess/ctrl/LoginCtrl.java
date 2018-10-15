package com.sguess.ctrl;

import com.sun.org.apache.xpath.internal.operations.Mod;
import jdk.management.resource.internal.inst.StaticInstrumentation;
import org.apache.commons.logging.impl.SLF4JLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger=LoggerFactory.getLogger(LoginCtrl.class);
    @RequestMapping(value = "/login")
    public String logonPage(Model model) {
        model.addAttribute("loginTime", new Date().toString());
        logger.info("Ready to login");
        return "login";
    }
}
