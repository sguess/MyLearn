package com.sguess.ctrl;

import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageCtrl {
    private static final Logger LOG = LoggerFactory.getLogger(PageCtrl.class);

    @RequestMapping(value = "radio")
    public String pageRedio() {
        LOG.info("Accessed the pageredio");
        return "radio";
    }

    @RequestMapping(value = "test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("Start to invoke the test function");
        String val=request.getParameter("sex");
        LOG.info("the attribute value is " + val);
        return "radio";
    }
}
