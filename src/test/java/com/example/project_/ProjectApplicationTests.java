package com.example.project_;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.entity.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProjectApplicationTests {
//	 @Autowired
//	 newsMapper newsMapper;
//	 @Autowired
//	 JdbcTemplate jdbcTemplate;
//	 @Autowired
//	 NewsMapper newsService;
//	@Autowired
//	NewsMapper newsMapper;
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	@Autowired
//	NewsMapper newsService;
//	@Test
//	public void findAll() {
//		List<News> list = new ArrayList<>();
//		list = jdbcTemplate.query("select * from news;", new BeanPropertyRowMapper<>(News.class));
//		System.out.print(list);
//	}
//	@Test
//	public void test() throws SQLException {
//		Integer id=100;
//		String name="hh";
//		String password="xx";
//		newsService.insert(id,name,password);
//	}
	@Test
	public void test1() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/computationalthinking?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai","root","root");
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO news (id,username,password) VALUES ( ?, ?, ? )");
		String a1 = new String("INSERT INTO   news (id,username,password) VALUES (?, ?, ?)");
		String s = new String("INSERT INTO  news (id,username,password) VALUES (?, ?, ?)");
		for (int i = 0; i < s.length(); i++) {
			if(a1.charAt(i)!=s.charAt(i)){
				System.out.println(i);
				System.out.println(a1.charAt(i)+"        "+s.charAt(i));
			}
		}
//		preparedStatement.setInt(1,321565);
//		preparedStatement.setString(2,"asdasda");
//		preparedStatement.setString(3,"sdfasfaf");
//		System.out.println(preparedStatement.executeUpdate());
	}
	@Test
	public void main(){
//		newsService.update(1,"hh","mm","ok","1999-10-10","1","oj.jpg","qs","3");
//		newsService.insert(3,"hh","mm","ok","1999-10-10","1","oj.jpg","qs","3");
//		// System.out.println(newsService.findByCondition("username", "xx"));
//		newsService.delete(2);
//		System.out.println(newsService.findAll());
	}


}
