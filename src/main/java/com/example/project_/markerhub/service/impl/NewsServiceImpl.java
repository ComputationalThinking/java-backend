package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.mapper.NewsMapper;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;
//import orggit.springframework.stereotype.Service;

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

    @Override
    public List<News> findAll() {
        return null;
    }

//    //查询所有
//    @Override
//    public List<News> findAll() {
//        List<News> list = new ArrayList<>();
//        return jdbcTemplate.query("select * from news;", new BeanPropertyRowMapper<>(News.class));
//    }
//    @Override
//     //增加数据
//     public void addOne(Integer id,String title,String author,String content,String time,String img_boolean,String img_src,String sort){
//        String sql= "insert into news values("+id+",'"+title+"','"+author+"','"+content+"','"+time+"',"+img_boolean+",'"+img_src+"','"+sort+"')";
//        jdbcTemplate.update(sql);
//    }
//
//    //根据条件查询
//    @Override
//    public List<News> findByCondition(String attribute,String key){
//        List<News> list = new ArrayList<>();
//        String sql="SELECT * FROM "+ 'News'+" WHERE "+ attribute +" LIKE '%"+key+"%'";
//        list=getMapper(sql,News);
//        return list;
//    }
//    //更新数据
//    @Override
//    public void updata(String attribute,String value,String id){
//        String sql ="UPDATE " + 'News' + " SET " + attribute + " = '" + value + "' WHERE id = " + id;
//        jdbcTemplate.update(sql);
//    }
//    //删除数据
//    @Override
//    public void delete(String id){
//        String sql="delete from "+ News +" where id=" + id;
//        jdbcTemplate.update(sql);
//    }
}


