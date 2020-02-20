package com.taehwan.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.taehwan.beans.JdbcBean;
import com.taehwan.config.BeanConfigClass;
import com.taehwan.db.jdbcDAO;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigClass.class);

		jdbcDAO dao = context.getBean(jdbcDAO.class);

		JdbcBean beans1 = new JdbcBean();
		
		dao.delete_data(1);
		
		beans1.setInt_data(2);
		beans1.setStr_data("테스트 테스트.");
		beans1.setWriter("임태환");
		dao.insert_data(beans1);

		
		JdbcBean bean2 = new JdbcBean(); 
		bean2.setInt_data(2);
		bean2.setStr_data("20200220"); 
		dao.update_data(bean2);
		 

		List<JdbcBean> list = dao.select_data();

		for (JdbcBean bean : list) {
			System.out.println(bean.getInt_data());
			System.out.println(bean.getStr_data());
			System.out.println(bean.getWriter());

		}

		context.close();
	}
}
