package com.ge.utility;

import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.ge")
@EnableWebMvc
public class WebConfigurationUtility {
	Logger logger = null;

	public WebConfigurationUtility() {
		logger = LoggerUtility.getLogger();
		logger.info("WebConfigurationUtility object is created");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		logger.trace("ViewResolver method execution started");
		InternalResourceViewResolver viewResolver = null;
		try {
			viewResolver = new InternalResourceViewResolver();
			logger.info("InternalResourceViewResolver Object is created");
			viewResolver.setPrefix("/jsps/");
			viewResolver.setSuffix(".jsp");
		} catch (Exception exception) {
			logger.error("InternalResourceViewResolver object creation Failed :" + exception.getMessage());
		}
		logger.trace("ViewResolver method completed execution :");
		return viewResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		logger.trace("messageSource method execution started");
		ResourceBundleMessageSource messageSource = null;
		try {
			messageSource = new ResourceBundleMessageSource();
			logger.info("ResourceBundleMessageSource Object is created");
			messageSource.addBasenames("errors");
		} catch (Exception exception) {
			logger.error("ResourceBundleMessageSource object creation Failed :" + exception.getMessage());
		}

		logger.trace("messageSource method execution completed");
		return messageSource;
	}
}
