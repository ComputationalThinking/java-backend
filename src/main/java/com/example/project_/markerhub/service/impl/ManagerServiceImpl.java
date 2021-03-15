package com.example.project_.markerhub.service.impl;

import com.alibaba.druid.mock.MockConnection;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.mapper.ManagerMapper;
import com.example.project_.markerhub.service.ManagerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    private BeanPropertyRowMapper<Manager> ManagerMapper = new BeanPropertyRowMapper<>(Manager.class);

    //查询所有
    @Override
    public List<Manager> findAll() {
        return jdbcTemplate.query("select * from manager;", new BeanPropertyRowMapper<>(Manager.class));
    }
    //根据条件查询
    @Override
    public List<Manager> findByCondition(String attribute, String key){
        List<Manager> list = new ArrayList<>();
        String sql="SELECT * FROM "+ "manager"+" WHERE "+ attribute +" LIKE '%"+key+"%'";
        list=jdbcTemplate.query(sql,ManagerMapper);
        return list;
    }

    //更新数据
    @Override
    public void update(String attribute,String value,Integer id){
        String sql ="UPDATE " + "manager" + " SET " + attribute + " = '" + value + "' WHERE id = " + id;
        jdbcTemplate.update(sql);
    }
    //更新所有数据
    @Override
    public void updateAll(String newUsername,String newPassword,Integer id){
        String sql = "update manager set username = ?,password = ? where id = ?";
        Object[] args = { newUsername,newPassword,id };
        int[] argTypes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
        jdbcTemplate.update(sql, args, argTypes);
    }
    //添加数据
    @Override
    public void insert(Integer id, String username, String password)  {
        String sql="insert into manager values("+id+",'"+username+"','"+password+"')";
        jdbcTemplate.update(sql);
    }
    //删除数据
    @Override
    public void delete(Integer id){
        String sql="delete from "+ "manager" +" where id=" + id;
        jdbcTemplate.update(sql);
    }
}