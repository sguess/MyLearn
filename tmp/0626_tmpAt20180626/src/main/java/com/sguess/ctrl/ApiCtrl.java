package com.sguess.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class ApiCtrl {

    @GetMapping(value = "")
    public String apiHome() {
        return new String("This is api home page");
    }
}
