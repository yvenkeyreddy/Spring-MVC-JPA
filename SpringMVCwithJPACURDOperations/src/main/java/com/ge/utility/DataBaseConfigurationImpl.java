package com.ge.utility;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:database.properties")
public class DataBaseConfigurationImpl {

	private Logger logger = null;

	public DataBaseConfigurationImpl() {
		logger = LoggerUtility.getLogger();
		logger.info("DataBaseConfigurationImpl object is created");
	}

	@Inject
	private Environment environment;
	@Inject
	private DataSource dataSource;
	// private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

	@Bean
	public DataSource dataSource() {
		logger.trace("DataSource method execution started");
		// try {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.db.driverClass"));
		dataSource.setUrl(environment.getProperty("spring.db.url"));
		dataSource.setUsername(environment.getProperty("spring.db.username"));
		dataSource.setPassword(environment.getProperty("spring.db.password"));
		// } catch (Exception exception) {
		// logger.error("DataSource object creation failed" +
		// exception.getMessage());
		// }
		logger.trace(" DataSource method executed completed");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		logger.trace("entityManagerFactory method execution started");
		// try {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan("com.ge.entity");
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactoryBean.setLoadTimeWeaver(loadTimeWeaver());
		// } catch (Exception exception) {
		// logger.error("LocalContainerEntityManagerFactoryBean object creation
		// failed" + exception.getMessage());
		// }
		logger.trace("entityManagerFactory method execution completed");
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		logger.trace("transactionManager method execution started");
		// try {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
		// } catch (Exception exception) {
		// logger.error("JpaTransactionManager object creation failed" +
		// exception.getMessage());
		// }
		// logger.trace("transactionManager method execution completed");
		// return transactionManager();
	}

	@Bean
	public LoadTimeWeaver loadTimeWeaver() {
		logger.trace("loadTimeWeaver method execution started");
		try {
			InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
			return loadTimeWeaver;
		} catch (Exception exception) {
			logger.error("loadTimeWeaver object creation failed" + exception.getMessage());
		}
		logger.trace("loadTimeWeaver method execution completed");
		return loadTimeWeaver();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		logger.trace("jpaVendorAdapter method execution started");
		// try {
		// EclipseLinkJpaVendorAdapter vendorAdapter = new
		// EclipseLinkJpaVendorAdapter();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		return vendorAdapter;
		// } catch (Exception exception) {
		// logger.error("jpaVendorAdapter object creation failed" +
		// exception.getMessage());
		// }
		// logger.trace("jpaVendorAdapter method execution completed");
		// return jpaVendorAdapter();
	}
}