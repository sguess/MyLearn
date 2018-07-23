package com.sguess.service;

import com.sguess.dao.IStuDao;
import com.sguess.dao.entity.StuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService {

    @Autowired
    IStuDao dao;


    public void save(StuEntity stuEntity) {

    }
}
