package com.sguess.learn.dao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.*;

import com.sguess.learn.bean.City;

public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    City findByNameAndStateAllIgnoringCase(String name, String state);
    
}