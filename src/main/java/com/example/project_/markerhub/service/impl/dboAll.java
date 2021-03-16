package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.News;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class dboAll {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<News> NewsMapper = new BeanPropertyRowMapper<>(News.class);
    private BeanPropertyRowMapper<Manager> ManagerMapper = new BeanPropertyRowMapper<>(Manager.class);
    private BeanPropertyRowMapper<Achieve> AchieveMapper = new BeanPropertyRowMapper<>(Achieve.class);
    private BeanPropertyRowMapper<Member> MemberMapper = new BeanPropertyRowMapper<>(Member.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Object> getMapper(String sql,String tableName){
        List message = new ArrayList();
        if(tableName.equals("news")){
            message = jdbcTemplate.query(sql,NewsMapper);
        }else if(tableName.equals("manager")){
            message = jdbcTemplate.query(sql,ManagerMapper);
        }else if(tableName.equals("achieve")){
            message = jdbcTemplate.query(sql,AchieveMapper);
        }else if(tableName.equals("member")){
            message = jdbcTemplate.query(sql,MemberMapper);
        }
        return message;
    }
    //根据某属性查询
    public List<Map<String, Object>> findOne(String tableName, String attribute, String key){

        String sql="SELECT * FROM ?  WHERE  ?  LIKE %?%";
        Object []args={ tableName,attribute,key};
        int[] argTypes={Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
        return jdbcTemplate.queryForList(sql,args,argTypes);

    }
    //更新数据
    public void updateOne(String tableName,String attribute,String value,Integer id){
        String sql ="UPDATE " + tableName + " SET " + attribute + " = '" + value + "' WHERE id = " + id;
        jdbcTemplate.update(sql);
    }

    //删除数据
    public void delete(String tableName,Integer id){
        String sql="delete from "+ tableName +" where id=" + id;
        jdbcTemplate.update(sql);
    }
}
