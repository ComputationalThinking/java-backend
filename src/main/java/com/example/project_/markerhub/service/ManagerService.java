package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project_.markerhub.entity.News;

import java.util.List;

public interface ManagerService extends IService<Manager> {
    List<Manager> findAll();
    //查询单个
//    List<Object> findByCondition();
    添加数据
    void insert(String id,String password);
//    修改数据
//    void update();
//    删除数据
//    void delete();
}
