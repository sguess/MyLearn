package com.sguess.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ScreenCtrl {

    @RequestMapping
    public void homePage(ModelAndView view, HttpServletRequest request, HttpServletResponse response) {

    }
}
