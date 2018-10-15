package com.sguess.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCtrl {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
