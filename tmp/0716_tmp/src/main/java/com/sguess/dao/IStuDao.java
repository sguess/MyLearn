package com.sguess.dao;

import com.sguess.dao.entity.StuEntity;

import java.util.Date;
import java.util.List;

public interface IStuDao {
    StuEntity save(StuEntity stuEntity);

    StuEntity findById(Long id);

    StuEntity findByTime(Date time);

    List<StuEntity> getStuListByTime(Date time);

    List<StuEntity> selectBySpecifyDate(int year, int month, int day);

}
