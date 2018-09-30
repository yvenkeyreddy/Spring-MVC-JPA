package com.ge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ge.entity.LoginDetails;
import com.ge.utility.LoggerUtility;

@Repository
public class LoginDetailsDAO {

	Logger logger = null;
	@PersistenceContext
	private EntityManager entityManager;

	public LoginDetailsDAO() {
		logger = LoggerUtility.getLogger();
		logger.info("LoginDetailsDAO class object is created");
	}

	public boolean loginTest(LoginDetails loginDetails) {
		try {
			if (loginDetails != null) {
				logger.trace("loginTest method executation started from DAO module");
				String jquery = "select username,password from login_details where username=? and password=?";
				Query query = entityManager.createNativeQuery(jquery, LoginDetails.class);
				query.setParameter(1, loginDetails.getUsername());
				query.setParameter(2, loginDetails.getPassword());

				@SuppressWarnings("unchecked")
				List<LoginDetails> list = query.getResultList();
				if (list != null && list.size() > 0) {
					System.out.println(list.toString());
					logger.trace("loginTest method executation complated from DAO module");
					return true;
				} else {
					logger.trace("loginTest method executation complated from DAO module with errors");
					return false;
				}
			} else {
				logger.trace("loginTest method throws Exception due to loginDetails is null");
				throw new Exception();
			}
		} catch (Exception e) {
			logger.error("loginTest method throws Exception" + e.toString());
		}
		return true;
	}
}
