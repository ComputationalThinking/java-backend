package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.mapper.NewsMapper;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    private dboAll dbo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有
    @Override
    public List<News> findAll() {
        List<News> list = new ArrayList<>();
        return jdbcTemplate.query("select * from news;", new BeanPropertyRowMapper<>(News.class));
    }
    //根据条件查询
//    @Override
//    public List<Object> findByCondition(String attribute,String key){
//
//    }
    //更新数据
//    @Override
//    public void update(String attribute,String key,Integer id){
//
//    }
//    //添加数据
//    @Override
//    public void insert(){
//
//    }
    //删除数据
//    @Override
//    public void delete(Integer id){
//
//    }

}
