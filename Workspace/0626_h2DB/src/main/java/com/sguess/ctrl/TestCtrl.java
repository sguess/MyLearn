package com.sguess.ctrl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sguess.entity.Bean;
import com.sguess.service.TestService;

@RestController
public class TestCtrl {

    @Autowired
    public TestService service;

    @RequestMapping(value = "/test")
    public List<Bean> testAll() {
        List<Bean> list = service.getData();
        System.out.println(list.size());
//		return Arrays.toString(list.toArray());
        return list;
    }

    @GetMapping(value = "/insert/{name}")
    public String insert(@PathVariable("name") String name) {
        Bean bean = new Bean();
        bean.setName1(name + ",1");
        bean.setName2(name + ",2");
        return service.insertBean(bean).toString();
    }

}
