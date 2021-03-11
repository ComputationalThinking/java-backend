package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService extends IService<News> {
//    查询所有
    List<News> findAll();
//    查询单个
//    List<Object> findByCondition(String attribute,String key);
//    添加数据
//    void insert();
//    修改数据
//    void update(String attribute,String key,Integer id);
//    删除数据
//    void delete(Integer id);
}
