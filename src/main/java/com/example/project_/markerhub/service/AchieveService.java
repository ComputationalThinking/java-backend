package com.example.project_.markerhub.service;

import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Achieve;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

public interface AchieveService extends IService<Achieve> {
    //查询所有
    List<Achieve> findALL();
    //查询单个
    List<Achieve> findByCondition(String value,Integer sort);
    //    添加数据
    void update(Achieve achieve);
    //    修改数据
    void insert(Achieve achieve);
    //    删除数据
    void delete(Integer id);
    Achieve searchById(Integer id);
    Result getPageList(int pageNum, int pageSize);
}