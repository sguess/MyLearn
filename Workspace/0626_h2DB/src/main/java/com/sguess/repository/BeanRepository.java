package com.sguess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sguess.entity.Bean;

@Repository
public interface BeanRepository extends JpaRepository<Bean,Integer>{

}
