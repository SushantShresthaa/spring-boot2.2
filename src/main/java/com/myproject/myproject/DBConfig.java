package com.myproject.myproject;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	@Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    //MySQL database we are using
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/myproject?useSSL=false");//change url
	    dataSource.setUsername("root");//change userid
	    dataSource.setPassword("Sushant9870");//change pwd
	    return dataSource;
	 }

	  //<bean id ="jdbcTemplate" class ="org.springframework.jdbc.core.JdbcTemplate"/>
	  @Bean
	  public JdbcTemplate createJdbcTemplate() {
		  JdbcTemplate jdbcTemplate =new JdbcTemplate(this.dataSource());
		  return jdbcTemplate;
	  }
}
