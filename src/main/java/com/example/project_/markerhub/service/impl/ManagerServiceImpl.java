package com.example.project_.markerhub.service.impl;

import com.alibaba.druid.mock.MockConnection;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    ManagerService userService;
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
        String sql=null;
        if(attribute.equals("username")){
            sql ="select * from manager where username=?";
        }
        else if(attribute.equals("password")){
            sql ="select * from manager where password=?";
        }
        Object[] args={key};
        int[] argTypes={Types.VARCHAR};
        list=jdbcTemplate.query(sql,args,argTypes,ManagerMapper);
        return list;
    }

    //更新数据
    @Override
    public void update(String attribute,String value,Integer id){
        String sql=null;
        if(attribute.equals("username")){
            sql ="UPDATE manager SET username=? WHERE id=?";
        }
        else if(attribute.equals("password")){
            sql ="UPDATE manager SET password=? WHERE id=?";
        }
        Object[] args={value,id};
        int[] argTypes={Types.VARCHAR,Types.INTEGER};
        jdbcTemplate.update(sql,args,argTypes);
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
    public void insert(String username, String password)  {
        String sql="insert into manager values(null ,?,?)";
        Object[] args={username,password};
        int[] argTypes={Types.VARCHAR,Types.VARCHAR};
        jdbcTemplate.update(sql,args,argTypes);
    }
    //删除数据
    @Override
    public void delete(Integer id){
        String sql="delete from manager  where id= ?";
        Object[] args={id};
        int[] argTypes={Types.INTEGER};
        jdbcTemplate.update(sql,args,argTypes);
    }
    @Override
    public List<Manager> getPageList(int pageNum,int pageSize) {
        IPage<Manager> IPage = new Page<Manager>(pageNum, pageSize);
        IPage<Manager> page = userService.page(IPage);
        long total = page.getTotal();
        System.out.println(total);
        List<Manager> records = page.getRecords();
        return records;
    }
}
