package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
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
       news.setId(3);
       news.setTitle("The history of News");
       news.setAuthor("水冰月");
//       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setImg_boolean(0);
       news.setImg_src("c");
       news.setContent("however");
       news.setSort(3);
       newsService.update(news);
   }
   @GetMapping("/Delete")
   public void delete(){
       News news=new News();
       news.setId(4);
       newsService.delete(1);
   }
   @GetMapping("/Insert")
   public void insert(){
       News news=new News();
       news.setTitle("Hello World!");
       news.setAuthor("happy monkey");
//       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setTime(LocalDateTime.of(2021,12,12,10,11,12));
       news.setImg_boolean(0);
       news.setImg_src("main.jpg");
       news.setContent("whatever");
       news.setSort(1);
       newsService.insert(news);
   }
   @GetMapping("/search")
    public List<News> search(){
        String title = "国内";
        List<News> list = newsService.conditionSearch(1,"%"+title+"%");
        return list;
   }
    @GetMapping("/giveID")
//    @PostMapping("/searchByID")
    public News giveID(@RequestParam("id") Integer id){
        News news;
        news = newsService.searchById(id);
        return news;
   }

    @GetMapping("/DeleteID")
    public List<News> deleteID(@RequestParam("id") Integer id){
        newsService.delete(id);
        return findAll();
    }

    @RequestMapping(value = "/UpdataID",method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
//    @GetMapping("/UpdataID")
    public void updateID(@RequestBody News news){
//        News news=new News();
        newsService.update(news);
//        System.out.println(news);
    }

    @RequestMapping(value = "/AddID",method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
//    @GetMapping("/AddID")
    public void InsertID(@RequestBody News news){
        newsService.insert(news);
    }

    //获取分页数据
    @GetMapping("/getPageData")
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return newsService.getPageList(page, limit);
    }
}
