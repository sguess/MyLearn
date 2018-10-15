package com.sguess.dao.impl;

import com.sguess.dao.IMockDao;
import com.sguess.dao.entity.MockEntity;
import com.sguess.dao.repository.MockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockDaoImpl implements IMockDao {
    @Autowired
    MockRepository repository;

    @Override
    public void save(MockEntity entity){
        repository.save(entity);
    }

    @Override
    public List<MockEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
