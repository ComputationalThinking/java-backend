package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.mapper.AchieveMapper;
import com.example.project_.markerhub.service.AchieveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchieveServiceImpl extends ServiceImpl<AchieveMapper, Achieve> implements AchieveService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有
    @Override
    public List<Achieve> findALL() {
        return jdbcTemplate.query("select * from achieve;", new BeanPropertyRowMapper<>(Achieve.class));
    }

//    //根据条件查询
//    @Override
//    public List<Achieve> findByCondition(){
//        List<Achieve> list = new ArrayList<>();
//
//        return list;
//    }
//    //更新数据
//    @Override
//    public void updata(){
//
//    }
//    //添加数据
//    @Override
//    public void insert(){
//
//    }
//    //删除数据
//    @Override
//    public void delete(){
//
//    }
}
