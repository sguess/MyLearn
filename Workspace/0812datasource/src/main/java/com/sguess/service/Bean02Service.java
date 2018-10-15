package com.sguess.service;

import org.springframework.stereotype.Service;

@Service(value = "bean02")
public class Bean02Service implements IBeanService {

    @Override
    public void printInfo() {
        System.out.println("This is bean 02");
    }
}
