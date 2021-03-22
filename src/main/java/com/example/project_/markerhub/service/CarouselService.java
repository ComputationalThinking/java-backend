package com.example.project_.markerhub.service;

import com.example.project_.markerhub.entity.Carousel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

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
}
