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
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<News> NewsMapper = new BeanPropertyRowMapper<>(News.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Object> getMapper(String sql){
        List message = new ArrayList();
        message = jdbcTemplate.query(sql,NewsMapper);
        return message;
    }
   //查询所有
   @Override
   public List<News> findAll() {
       List<News> list = new ArrayList<>();
       return jdbcTemplate.query("select * from news;", new BeanPropertyRowMapper<>(News.class));
   }

   //根据条件查询
   @Override
   public List<News> findByCondition(String attribute,String key){
       String sql="SELECT * FROM news"+" WHERE "+ attribute +" LIKE '%"+key+"%'";
       List list=getMapper(sql,News);
       return list;
   }
   //更新数据
   @Override
   public void update(News news){
       String sql ="UPDATE news set sort=?,title=?,author=?,content=?,time=?,img_bollean=?,img_src=? where id=?";
       jdbcTemplate.update(sql,news.getTitle(),news.getAuthor(),news.getContent(),news.getTime(),news.getImg_boolean(),news.getImg_src(),news.getSort(),news.getId());
   }
   @Override
   //添加数据
   @Override
   public void insert(News news){
       //String sql="insert into news values ("+id+",'"+name+"',"+identity+",'"+content+"','"+tel+"','"+email+"',"+area+",'"+role+"')";
       String sql="insert into news values (?,?,?,?,?,?,?,?)";
       jdbcTemplate.update(sql,news.getId(),news.getTitle(),news.getAuthor(),news.getContent(),news.getTime(),news.getImg_boolean(),news.getImg_src(),news.getSort());
   }
   //删除数据
   @Override
   public void delete(News news){
       String sql="delete from news where id=?";
       jdbcTemplate.update(sql,news.getId());
   }
}


