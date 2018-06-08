package com.sguess;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadAppService {
	@Value("${test.value}")
	public String testValue;

	@RequestMapping("/")
	public String getValue() {
		System.out.println("-------------" + testValue);
		return testValue;
	}
}
