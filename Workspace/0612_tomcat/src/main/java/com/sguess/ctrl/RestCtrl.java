package com.sguess.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestCtrl {
    @RequestMapping(value = "/a")
    @ResponseBody
    public String getStr() {
        return "001";
    }

    @RequestMapping(value = "/main")
    public String getmain() {
        return "main";
    }

    @RequestMapping(value = "/")
    public String getHomePage() {
        return "index";
    }
}
