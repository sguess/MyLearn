package com.sguess.service.impl;

import com.sguess.dao.IMockDao;
import com.sguess.dao.entity.MockEntity;
import com.sguess.service.IMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockServiceImpl implements IMockService {
    @Autowired
    IMockDao dao;

    @Override
    public List<MockEntity> mockTest() {
        List<MockEntity> list = dao.findAll();
        if (list == null) {
            return new ArrayList<>();
        }
        for (MockEntity mockEntity : list) {
            mockEntity.setAge(mockEntity.getAge() + 100);
        }
        System.out.println("list.size():" + list.size());
        return list;
    }
}
