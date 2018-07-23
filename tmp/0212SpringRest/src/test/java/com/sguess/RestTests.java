package com.sguess;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RestTests {

	@Test
	public void contextLoads() {
		User user=this.fetchFacebookProfile(1);
		System.out.println(user.toString());
	}

	public User fetchFacebookProfile(int id) {
		RestTemplate rest = new RestTemplate();
//		return rest.getForObject("http://graph.facebook.com/{spitter}", Profile.class, id);
		return rest.getForObject("http://localhost:8080/rest/get01/{id}", User.class, id);
	}
	@Test
	public void funTmp() {
		
	}
	

}
