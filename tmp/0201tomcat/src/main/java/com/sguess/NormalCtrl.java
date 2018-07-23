package com.sguess;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NormalCtrl {
	
	@RequestMapping("/a")
	public String fun1() {
		return "abc";
	}
}
