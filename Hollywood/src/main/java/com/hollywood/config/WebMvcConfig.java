package com.hollywood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.hollywood.dao.AtorDao;
import com.hollywood.dao.AtorDaoImpl;

//@Configuration
//@EnableWebMvc
//@ComponentScan("com.hollywood")
public class WebMvcConfig {

	//@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
	}

	//@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/hollywood");
		ds.setUsername("root");
		ds.setPassword("senhanova");

		return ds;
	}

	//@Bean
	public AtorDao getUserDao() {
		return new AtorDaoImpl(getDataSource());
	}
}