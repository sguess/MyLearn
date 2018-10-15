package com.sguess.eureka.client.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
public class HelloCtrl {
    private static Logger LOG = LoggerFactory.getLogger(HelloCtrl.class);
    @Autowired
    DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {

        List<String> instanceList = client.getServices();
        for (String s : instanceList) {
            System.out.println("------------->" + s);

        }
        List<ServiceInstance> instances = client.getInstances("Client");
        for (ServiceInstance instance : instances) {
            System.out.println("instance:"+instance.getHost()+",\t"+instance.getServiceId());
        }

        LOG.info("This is index function.");
        return "Hello world!";
    }

}
