package com.ge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(path = "/a", method = RequestMethod.GET)
	public String display() {
		System.out.println("test");
		return "test";
	}
}
