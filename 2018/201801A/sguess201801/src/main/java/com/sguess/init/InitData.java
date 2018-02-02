package com.sguess.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sguess.dao.SysParaRepository;
import com.sguess.entity.SysPara;

@Service
public class InitData {
	@Autowired
	private SysParaRepository sysParaRep;
	
//	@PostConstruct
	public void init() {
//		sysParaRep.save(new SysPara("abc","token"));
	}
}
