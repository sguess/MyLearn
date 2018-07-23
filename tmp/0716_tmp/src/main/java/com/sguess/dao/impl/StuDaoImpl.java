package com.sguess.dao.impl;

import com.sguess.dao.IStuDao;
import com.sguess.dao.entity.StuEntity;
import com.sguess.dao.mapper.StuMapper;
import com.sguess.dao.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class StuDaoImpl implements IStuDao {

    @Autowired
    StuRepository repository;

//    @Autowired
//    StuMapper mapper;

    @Override
    public StuEntity save(StuEntity stuEntity) {
        StuEntity rst = repository.save(stuEntity);
        return rst;
    }

    @Override
    public StuEntity findById(Long id) {
        StuEntity rst = repository.getById(id);
        return rst;
    }

    @Override
    public StuEntity findByTime(Date time) {
        StuEntity rst = repository.getByTime(time);
        return rst;
    }

    @Override
    public List<StuEntity> getStuListByTime(Date time) {
        List<StuEntity> rstList = repository.getByTimeContaining(time);
        if(rstList==null||rstList.size()==0){
            System.out.println("-------------------------------------");
            rstList = repository.getByTimeContains(time);
        }
        return rstList;
    }

    @Override
    public List<StuEntity> selectBySpecifyDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        Date startDate=c.getTime();
        c.add(Calendar.DAY_OF_MONTH,1);
        Date endDate=c.getTime();
        return repository.findByTimeBetween(startDate,endDate);
    }
}
