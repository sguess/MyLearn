package com.sguess.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service(value = "bean01")
@Primary
public class Bean01Service implements IBeanService {

    @Override
    public void printInfo() {
        System.out.println("This is bean 01");
    }
}
