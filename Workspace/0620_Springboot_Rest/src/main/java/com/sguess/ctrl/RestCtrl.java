package com.sguess.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sguess.bean.Ele;

@RestController
@RequestMapping(value = "/rest/")
public class RestCtrl {

	@GetMapping(value = "get")
	public String funGet() {
		return "getRst";
	}

	@GetMapping(value = "getEle/css/{css}/str/{str}")
	public Ele funPath(@PathVariable String css, @PathVariable String str) {
		return new Ele(css, str);
	}

	@PostMapping(value = "postObj")
	public Ele postObj(@RequestBody Ele ele) {
		ele.setCss("css-->" + ele.getCss());
		ele.setStr("str-->" + ele.getStr());
		return ele;
	}
}
