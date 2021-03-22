package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Carousel;
import com.example.project_.markerhub.mapper.CarouselMapper;
import com.example.project_.markerhub.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询全部
    @Override
    public List<Carousel> findALL(){
        return jdbcTemplate.query("select * from carousel",new BeanPropertyRowMapper<>(Carousel.class));
    }
    //添加
    @Override
    public void insert(Carousel carousel){
        String sql = "insert into carousel values(null,?,?)";
        jdbcTemplate.update(sql,carousel.getPic(),carousel.getPage());
    }
    //删除
    @Override
    public void delete(Integer id){
        String sql = "delete from carousel where id= ?";
        jdbcTemplate.update(sql,id);
    }
    //修改
    @Override
    public void update(Carousel carousel){
        String sql = "update carousel set pic = ?,page = ? where id = ?";
        jdbcTemplate.update(sql,carousel.getPic(),carousel.getPage(),carousel.getId());
    }
}
