package com.sguess.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(HomePageCtrl.class);

    @RequestMapping(value = "/")
    public String homePage() {
        LOG.info("Open the home page.");
        return "index";
    }
}
