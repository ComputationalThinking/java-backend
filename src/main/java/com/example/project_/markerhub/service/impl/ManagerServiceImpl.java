package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.mapper.ManagerMapper;
import com.example.project_.markerhub.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有
    @Override
    public List<Manager> findAll() {
        return jdbcTemplate.query("select * from manager;", new BeanPropertyRowMapper<>(Manager.class));
    }
    //根据条件查询
    @Override
    public List<Manager> findByCondition(String attribute,String key){
        List<Manager> list = new ArrayList<>();
        String sql="SELECT * FROM "+ 'manager'+" WHERE "+ attribute +" LIKE '%"+key+"%'";
        list=getMapper(sql,manager);
        return list;
    }
    //更新数据
    @Override
    public void updata(String attribute,String value,String id){
        String sql ="UPDATE " + 'manager' + " SET " + attribute + " = '" + value + "' WHERE id = " + id;
        jdbcTemplate.update(sql);
    }
    //添加数据
    @Override
    public void insert(String id,String password){
        String sql="insert into manager values('"+id+"','"+password+"')";
        jdbcTemplate.update(sql);
    }
    //删除数据
    @Override
    public void delete(String id){
        String sql="delete from "+ manager +" where id=" + id;
        jdbcTemplate.update(sql);
    }
}
