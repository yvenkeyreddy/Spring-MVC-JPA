package com.ge.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebApplicationInitilizerImpl implements WebApplicationInitializer {

	private Logger logger = null;

	public WebApplicationInitilizerImpl() {
		logger = LoggerUtility.getLogger();
		logger.info("WebApplicationInitilizerImpl object is created");
	}

	@Override
	public void onStartup(ServletContext servletContext) {
		logger.trace("onStartup method execution started");
		try {
			AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
			context.register(WebConfigurationUtility.class);
			logger.trace("WebConfigurationUtility class registred successfully");
			context.register(DataBaseConfigurationImpl.class);
			logger.trace("DataBaseConfigurationImpl class registred successfully");
			context.setServletContext(servletContext);
			Dynamic dynamic = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
			logger.info("DispatcherServlet() Object is created successfully :");
			dynamic.setLoadOnStartup(5);
			dynamic.addMapping("/");
			context.close();
		} catch (Exception exception) {
			logger.error("context Object creation failed :" + exception.getMessage());
		}
		logger.trace("onStartup method execution completed");
	}
}
