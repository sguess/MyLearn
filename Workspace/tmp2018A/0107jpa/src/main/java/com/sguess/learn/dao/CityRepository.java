package com.sguess.learn.dao;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sguess.learn.bean.City;

public interface CityRepository extends JpaRepository<City, Integer> {

    Page<City> findAll(Pageable pageable);

    City findByNameAndStateAllIgnoringCase(String name, String state);

    @Query("Select name FROM city")
    List<City> queryAllCity();

}