package com.sguess.learn.dao;

import com.sguess.learn.bean.BigDecimalBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface BigDecimalRepository extends JpaRepository<BigDecimalBean, Long> {
    public BigDecimalBean getBigDecimalBeanById(Long id);

    public List<BigDecimalBean> getAllByNameContaining(String name);

    public List<BigDecimalBean> findAllByNameContaining(String name);

    @Query("select d from BigDecimalBean d where d.name=:name")
    public BigDecimalBean test001(@Param("name") String name);

    @Query(value = "select d.id,d.name,d.price from testTable d", nativeQuery = true)
    public List<BigDecimalBean> testAll();

    @Query(value = "select d.id,d.name,d.price from testTable d where name=?", nativeQuery = true)
    public List<BigDecimalBean> testName(String name);

    @Query(value = "select d.id,d.name,d.price from testTable d where name=:name", nativeQuery = true)
    public List<BigDecimalBean> testName2(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "insert into testTable (name) values (:name)", nativeQuery = true)
    public int test002(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "insert into testTable (price) values (:price)", nativeQuery = true)
    public int test002(@Param("price") BigDecimal price);

}
