package com.example.project_;

import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.News;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Test
	public void findAll() {
		List<Manager> list = new ArrayList<>();
		list = jdbcTemplate.query("select * from manager;", new BeanPropertyRowMapper<>(Manager.class));
		System.out.print(list);
	}

}
