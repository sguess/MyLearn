package com.sguess.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageCtrl {
    @RequestMapping(value = "/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/api")
    public String apiPage() {
        return "/api/index";
    }

    @RequestMapping(value = "/api/{id}")
    @ResponseBody
    public String apiRestPage(@PathVariable("id") String id) {
        return "Hello," + id;
    }

    @RequestMapping(value = "/oauth")
    public String oauthPage() {
        return "oauth/index";
    }
    @RequestMapping(value = "/common")
    public String commonPage() {
        return "common";
    }

}
