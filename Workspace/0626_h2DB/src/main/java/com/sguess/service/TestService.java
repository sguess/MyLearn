package com.sguess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sguess.entity.Bean;
import com.sguess.repository.BeanRepository;

@Service
public class TestService {

	@Autowired
	public BeanRepository repository;
	
	public List<Bean> getData() {
		List<Bean> list=repository.findAll();
		return list;
	}

	public Bean insertBean(Bean bean) {
		Bean rst = repository.save(bean);
		return rst;
	}
}
