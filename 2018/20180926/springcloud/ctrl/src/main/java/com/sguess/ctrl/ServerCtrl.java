package com.sguess.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController("/hello")
@Controller
@RequestMapping("hello")
public class ServerCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(ServerCtrl.class);

//    @GetMapping("{name}")
    @RequestMapping("{name}")
    @ResponseBody
    public String sayHello(@PathVariable("name") String name) {
        LOG.info("Say Hello, " + name);
        return "Hello, " + name;
    }
}
