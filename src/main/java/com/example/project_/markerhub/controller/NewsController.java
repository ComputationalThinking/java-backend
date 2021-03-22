package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/News")
public class NewsController {
    @Autowired
    NewsService userService;
    @GetMapping("/newsFindAll")
    public List<News> findAll(){
        List<News> list =userService.findAll();
        return list;
    }
//    @GetMapping("/newsFindByCondition")
//    public List<Object> findByCondition(){
//        List<Object> list =userService.findByCondition("identity","1");
//        return list;
//    }
//    @GetMapping("/newsUpdate")
//    public void update(){
//        News news=new News();
//        news.setId(1);
//        news.setTitle("The history of News");
//        news.setAuthor("水冰月");
//        news.setTime("2021-03-18");
//        news.setImg_boolean("1");
//        news.setImg_src("c:\desktop\op");
//        news.setContent("however");
//        news.setSort("2");
//        userService.update(news);
//    }
//    @GetMapping("/newsDelete")
//    public void delete(){
//        News news=new News();
//        news.setId(2);
//        userService.delete(news);
//    }
//    @GetMapping("/newsInsert")
//    public void insert(){
//        News news=new News();
//        news.setId(3);
//        news.setTitle("Hello World!");
//        news.setAuthor("happy monkey");
//        news.setTime("1996-03-18");
//        news.setImg_boolean("1");
//        news.setImg_src("main.jpg");
//        news.setContent("whatever");
//        news.setSort("3");
//        userService.insert(news);
//    }
}
