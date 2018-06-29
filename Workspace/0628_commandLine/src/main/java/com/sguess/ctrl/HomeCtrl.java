package com.sguess.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	private static final Logger log = LoggerFactory.getLogger(HomeCtrl.class);

	@RequestMapping(value = "/")
	public String homePage() {
		log.info("open the home page");
		return "index";
	}
}
