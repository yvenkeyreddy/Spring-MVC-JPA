package com.ge.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.LoginDetailsDAO;
import com.ge.entity.LoginDetails;
import com.ge.utility.LoggerUtility;

@Service
public class LoginDetailsService {

	Logger logger = null;
	@Autowired
	private LoginDetailsDAO loginDetailsDAO;

	public LoginDetailsService() {
		logger = LoggerUtility.getLogger();
		logger.info("LoginDetailsService class object created");
	}

	@Transactional(value = TxType.REQUIRED)
	public boolean loginCheck(LoginDetails loginDetails) {
		try {
			if (loginDetails != null) {
				logger.trace("loginCheck method executation started from services module");
				boolean test = loginDetailsDAO.loginTest(loginDetails);
				if (test == true) {
					logger.trace("loginCheck method executation completed from services module");
					return true;
				} else {
					logger.trace("loginCheck method executation completed with error login from services module");
					return false;
				}
			} else {
				logger.trace("loginCheck method throws Exception due to loginDetails is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("loginCheck method throws Exception" + e.toString());
		}
		return true;
	}
}
