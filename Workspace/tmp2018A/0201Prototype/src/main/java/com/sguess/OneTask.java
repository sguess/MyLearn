package com.sguess;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OneTask {
    @Autowired
    public InvokedService service;

    public void output() {
        System.out.println(new Date() + this.toString());
        service.anotherService();
    }
}
