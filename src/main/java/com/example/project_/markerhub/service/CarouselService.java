package com.example.project_.markerhub.service;

import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Carousel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project_.markerhub.entity.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CarouselService extends IService<Carousel> {

    //查询全部
    List<Carousel> findALL();
    //添加
    void insert(Carousel carousel);
    //删除
    void delete(Integer id);
    //修改
    void update(Carousel carousel);
//    List<Carousel> conditionSearch(String name);

    Carousel searchById(Integer id);
    //获取分页数据
    Result getPageList(int pageNum, int pageSize);
}
