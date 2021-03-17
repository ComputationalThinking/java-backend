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

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //根据条件查询
    @Override
    public List<Achieve> findByCondition(String attribute,String key){
        String sql="SELECT * FROM achieve WHERE "+ attribute +" LIKE '%"+key+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Achieve.class));
    }
    //更新数据
    @Override
    public void update(String attribute,String value,Integer id){
        String sql ="UPDATE achieve SET " + attribute + " = '" + value + "' WHERE id = " + id;
        jdbcTemplate.update(sql);
    }
    //添加数据
    @Override
    public void insert(Integer id, String title, String content, LocalDateTime time,Integer hot,String participantMember,Integer sort,String achieveName){
        String sql="insert into achieve values("+id+",'"+title+"','"+content+"','"+time+"',"+hot+",'"+participantMember+"',"+sort+",'"+achieveName+"')";
        jdbcTemplate.update(sql);
    }
    //删除数据
    @Override
    public void delete(Integer id){
        String sql="delete from achieve where id=" + id;
        jdbcTemplate.update(sql);
    }
}

