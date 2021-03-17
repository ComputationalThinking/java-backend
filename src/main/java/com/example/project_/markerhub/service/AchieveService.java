package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.Achieve;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

public interface AchieveService extends IService<Achieve> {
    //查询所有
    List<Achieve> findALL();
    //查询单个
    List<Achieve> findByCondition(String attribute,String key);
//    添加数据
    void update(String attribute,String value,Integer id);
//    修改数据
    void insert(Integer id, String title, String content, LocalDateTime time, Integer hot, String participantMember, Integer sort, String achieveName);
//    删除数据
    void delete(Integer id);
}
