package com.sguess.dao;

import com.sguess.dao.entity.MockEntity;

import java.util.List;

public interface IMockDao {
    void save(MockEntity entity);

    List<MockEntity> findAll();

    void deleteAll();

}
