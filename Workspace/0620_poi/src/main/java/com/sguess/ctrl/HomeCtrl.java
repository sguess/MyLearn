package com.sguess.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {

	@RequestMapping("/")
	public String homePage() {
		return "pages/index";
	}

	@RequestMapping("/fileinput")
	public String fileinput() {
		return "pages/fileinput";
	}

	@RequestMapping("/fileinput2")
	public String fileinput2() {
		return "pages/fileinput2";
	}

	@RequestMapping("/fileinput3")
	public String fileinput3() {
		return "pages/fileinput3";
	}

	@RequestMapping("/fileinput4")
	public String fileinput4() {
		return "pages/fileinput4";
	}

	@RequestMapping("/fileinput/{page}")
	public String fileinputPage(@PathVariable("page") String page) {
		return "pages/" + page;
	}
}
