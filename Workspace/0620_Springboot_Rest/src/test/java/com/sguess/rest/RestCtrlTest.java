package com.sguess.rest;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sguess.bean.Ele;

public class RestCtrlTest {

	String postUrl = "http://localhost:8080/rest/";

	@Test
	public void fun01() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> entity = rest.getForEntity(postUrl + "get", String.class);
		String body = entity.getBody();
		System.out.println(entity);
		System.out.println(body);
	}

	@Test
	public void fun02() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<Ele> entity = rest.getForEntity(postUrl + "getEle/css/c1/str/s1", Ele.class);
		Ele body = entity.getBody();
		System.out.println(entity);
		System.out.println(body);
	}

	@Test
	public void fun03() {
		RestTemplate rest = new RestTemplate();
		Ele ele = new Ele("c1", "s1");
		ResponseEntity<Ele> entity = rest.postForEntity(postUrl + "postObj", ele, Ele.class);
		Ele body = entity.getBody();
		System.out.println(entity);
		System.out.println(body);
	}
}
