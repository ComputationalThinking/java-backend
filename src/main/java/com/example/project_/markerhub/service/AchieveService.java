package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.Achieve;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface AchieveService extends IService<Achieve> {
    //查询所有
    List<Achieve> findALL();
    //查询单个
//    List<Object> findByCondition();
//    添加数据
//    void insert();
//    修改数据
//    void update();
//    删除数据
//    void delete();
}
