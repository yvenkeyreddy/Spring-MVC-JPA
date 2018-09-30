package com.ge.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	private static Logger logger;

	static {
		logger = LogManager.getLogger();
	}

	private LoggerUtility() {
		logger.info("LoggerUtility() Object is created");
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		LoggerUtility.logger = logger;
	}
}
