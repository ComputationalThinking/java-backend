package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/News")
public class NewsController {
    @Autowired
   private NewsService newsService;

    @GetMapping("/FindAll")
    public List<News> findAll(){
        List<News> list =newsService.findAll();
        return list;
    }
//   @GetMapping("/FindByCondition")
//   public List<Object> findByCondition(){
//       List<Object> list =NewsService.findByCondition("identity","1");
//       return list;
//   }
   @GetMapping("/Update")
   public void update(){
       News news=new News();
       news.setId(1);
       news.setTitle("The history of News");
       news.setAuthor("水冰月");
//       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setImg_boolean(0);
       news.setImg_src("c");
       news.setContent("however");
       news.setSort(3);
       newsService.update(news);
   }
   @GetMapping("/Delete")
   public void delete(){
       News news=new News();
       news.setId(1);
       newsService.delete(1);
   }
   @GetMapping("/Insert")
   public void insert(){
       News news=new News();
       news.setId(3);
       news.setTitle("Hello World!");
       news.setAuthor("happy monkey");
//       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setImg_boolean(0);
       news.setImg_src("main.jpg");
       news.setContent("whatever");
       news.setSort(1);
       newsService.insert(news);
   }
}
