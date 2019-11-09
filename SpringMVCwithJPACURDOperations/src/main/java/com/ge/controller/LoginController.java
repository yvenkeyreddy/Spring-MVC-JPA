package com.ge.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ge.entity.LoginDetails;
import com.ge.service.LoginDetailsService;
import com.ge.utility.LoggerUtility;

@Controller
public class LoginController {

	Logger logger = null;
	@Autowired
	private LoginDetailsService loginDetailsService;

	public LoginController() {
		logger = LoggerUtility.getLogger();
		logger.info("LoginController class object created");
	}

	@RequestMapping(path = { "/login", "/logout" }, method = RequestMethod.GET)
	public String loginForm(Model model) {
		logger.trace("loginForm method executation started from controller module");
		model.addAttribute("loginDetails", new LoginDetails());
		logger.trace("loginForm method executation completed from controller module");
		return "LoginForm";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginProcess(@Valid LoginDetails loginDetails, BindingResult result) {
		try {
			logger.trace("loginProcess method executation started from controller module");
			if (result.getErrorCount() > 0) {
				logger.trace("loginProcess method executation completed with errors from controller module");
				return "LoginForm";
			} else {
				boolean test = loginDetailsService.loginCheck(loginDetails);
				if (test == true) {
					logger.trace("loginProcess method executation completed from controller module");

					return "redirect:/allemployees";
				} else {
					logger.trace("loginProcess method executation completed with errors from controller module");
					return "ErrorForm";
				}
			}
		} catch (Exception e) {
			logger.error("loginProcess method throws Exception" + e.toString());
		}
		return "redirect:/allemployees";
	}
}
