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
    NewsService newsService;

    @GetMapping("/information")
    public List<News> getData(){
        List<News> list = newsService.findAll();
        return list;
    }

}

