package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.Manager;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.SQLException;
import java.util.List;

public interface ManagerService extends IService<Manager> {
    List<Manager> findAll();
    //查询单个
    List<Manager> findByCondition(String attribute, String key);
    //添加数据
    void insert(String name, String password);
    //修改单个数据
    void update(String attribute,String value,Integer id);
    //修改所有数据
    void updateAll(String newUsername,String newPassword,Integer id);
    //删除数据
    void delete(Integer id);
}
