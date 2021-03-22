package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsService extends IService<News> {
    List<News> findAll();
    //查询单个
//    List<News> findByCondition(String attribute,String key);
    //    添加数据
   void insert(News news);
   //    修改数据
   void update(News news);
   //    删除数据
   void delete(Integer id);
}