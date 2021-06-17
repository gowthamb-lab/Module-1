package com.egen;


import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

//	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		//TODO: configure emf
		LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(null);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","create");
		properties.put("hibernate.show_sql","true");

		emf.setJpaProperties(properties);

		return emf;
	}

//	@Bean
	public DataSource dataSource() {
		//TODO: configure data source bean

		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employee");
		ds.setUsername("root");
		ds.setPassword("50344484");
		return  ds;
	}

//	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		//TODO: configure transaction manager
		JpaTransactionManager txm= new JpaTransactionManager(emf);
		return txm;



	}

	private Properties jpaProperties() {
		//TODO: configure jpa properties
		return null;
	}
}
