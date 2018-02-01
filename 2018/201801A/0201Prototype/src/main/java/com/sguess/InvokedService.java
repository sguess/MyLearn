package com.sguess;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class InvokedService {
	public void anotherService() {
		System.out.println(new Date()+this.toString());
	}
}
