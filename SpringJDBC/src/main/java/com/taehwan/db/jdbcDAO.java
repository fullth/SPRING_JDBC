package com.taehwan.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.taehwan.beans.JdbcBean;


@Component
public class jdbcDAO {
	
	//BeanConfigClass 클래스의 jdbcTemplate클래스를 주입(@Autowired)됨.
	@Autowired //JDBC 관리 객체를 주입하는 것과 같은 의미.
	private JdbcTemplate db;
	
	@Autowired
	private Mapper mapper;
	
	//Data저장.
	public void insert_data(JdbcBean bean) {
		String sqlString = "INSERT INTO jdbc_table(int_data, str_data, writer)"
				+ "values(?,?,?)"; //prepared 방식. (찾아보기, 정확한 의미 모름.) 
		db.update(sqlString, bean.getInt_data(), bean.getStr_data(), bean.getWriter());
	}
	
	public List<JdbcBean> select_data() {
		String sqlString = "SELECT * FROM jdbc_table";
		List<JdbcBean> list = db.query(sqlString, mapper);
		 
		 return list;
	}
	
	public void update_data(JdbcBean bean) {
		String sqlString = "UPDATE jdbc_table SET str_data = ? WHERE int_data = ?";
		db.update(sqlString, bean.getInt_data(), bean.getStr_data());
	}
	
	public void delete_data(int int_data) {
		String sqlString = "DELETE jdbc_table WHERE int_data = ?" ;
		db.update(sqlString);
	}
}
