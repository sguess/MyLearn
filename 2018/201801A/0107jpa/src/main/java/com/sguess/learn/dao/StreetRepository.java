package com.sguess.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sguess.learn.bean.Street;


//public interface StreetRepository{
public interface StreetRepository extends JpaRepository<Street, Integer>{

}
