package com.taehwan.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages =  {"com.taehwan.beans", "com.taehwan.db"})
public class BeanConfigClass {
	
	@Bean
	public BasicDataSource source() {
		
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		source.setUsername("spring");
		source.setPassword("1234");
		
		return source;
	}
	
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		
		JdbcTemplate db = new JdbcTemplate(source); 
		
		return db;
	}
}
