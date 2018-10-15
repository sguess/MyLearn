package com.sguess.service;

import com.sguess.dao.a.entity.UserA;
import com.sguess.dao.a.repository.UserRepositoryA;
import com.sguess.dao.b.entity.UserB;
import com.sguess.dao.b.respository.UserRepositoryB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBService {
    @Autowired
    UserRepositoryA userRepositoryA;
    @Autowired
    UserRepositoryB userRepositoryB;

    @PostConstruct
    public void init() {
        userRepositoryA.save(new UserA("Tom", "1"));
        userRepositoryB.save(new UserB("Tom", "2"));
        userRepositoryA.findAll();
        userRepositoryB.findAll();
    }
}
