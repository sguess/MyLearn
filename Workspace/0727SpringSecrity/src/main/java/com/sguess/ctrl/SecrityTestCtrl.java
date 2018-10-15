package com.sguess.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecrityTestCtrl {

    @RequestMapping("/admin")
    public String admin() {
        return "This is admin page";
    }

    @RequestMapping("/admin01")
    public String admin01() {
        return "This is admin01 page";
    }

    @RequestMapping("/enduser")
    public String enduser() {
        return "This is enduser page";
    }

    @RequestMapping("/enduser01")
    public String enduser01() {
        return "This is enduser 01 page";
    }

    @RequestMapping("/normal")
    public String normal() {
        return "This is normal page";
    }

    @RequestMapping("/normal01")
    public String normal01() {
        return "This is normal01 page";
    }

    @RequestMapping("/api")
    public String api() {
        return "This is api page";
    }

    @RequestMapping("/api01")
    public String api01() {
        return "This is api 01 page";
    }

    @RequestMapping("/adminHomePage")
    public String adminHomePage() {
        return "This is adminHomePage";
    }

    @RequestMapping("/nomalPage")
    public String nomalPage() {
        return "This is nomalPage";
    }

}
