package com.sguess;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeCtrl {
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public String homePage(Model model) {
		System.out.println("--------------------");
		return "header";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("--------------------");
		return "index";
	}
	@RequestMapping(value = "/s01", method = RequestMethod.GET)
	public String homePageS01(Model model, HttpServletRequest request) {
		System.out.println("--------------------s01");
		request.getRequestDispatcher("s01");
		return "s01.html";
	}
}
