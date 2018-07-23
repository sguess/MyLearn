package com.sguess.dao.repository;

import com.sguess.dao.entity.StuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StuRepository extends JpaRepository<StuEntity, Long> {
    public StuEntity getById(Long id);

    public StuEntity getByTime(Date Time);

    public List<StuEntity> getByTimeContaining(Date Time);

    public List<StuEntity> getByTimeContains(Date Time);

    @Query(value = "SELECT id, name,time FROM student where DATE_FORMAT(time,'%Y%m%d')=:dayStr", nativeQuery = true)
    public List<StuEntity> selectStuListByDay(@Param("dayStr") String dayStr);

    public StuEntity streamAllById(Long id);

    public List<StuEntity> findByTime(String time);

    public List<StuEntity> findByTimeBetween(Date startDate,Date endDate);

    @Modifying
    @Transient
    @Query(value = "create table tbl01(id int, name varchar(20))", nativeQuery = true)
    public void createTable();

    @Modifying
    @Transient
    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();

    @Query(value = "SELECT id, name, time FROM :tableName", nativeQuery = true)
    List<StuEntity> selectAllbyTable(@Param("tableName") String tableName);

    @Query(value = "SELECT id, name,time FROM student", nativeQuery = true)
    public List<StuEntity> selectTmp001();
}
