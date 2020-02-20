package com.taehwan.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.taehwan.beans.JdbcBean;

@Component
public class Mapper implements RowMapper<JdbcBean>{

	@Override
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		JdbcBean bean = new JdbcBean();
		bean.setInt_data(rs.getInt("int_data"));
		bean.setStr_data(rs.getString("str_data"));
		bean.setWriter(rs.getString("writer"));
		
		return bean;
	}

}
