package com.sguess.robbin.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Controller
@RestController
public class RibbonCtrl {
    private static Logger LOG=LoggerFactory.getLogger(RibbonCtrl.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String ribbon(){
        LOG.info("This is load banlance");
        return restTemplate.getForEntity("http://client/hello",String.class).getBody();
    }



}
