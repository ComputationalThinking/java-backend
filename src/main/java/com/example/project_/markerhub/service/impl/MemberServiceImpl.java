package com.example.project_.markerhub.service.impl;

import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.mapper.MemberMapper;
import com.example.project_.markerhub.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private dboAll dboAll;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询所有
    @Override
    public List<Member> findALL(){
        return jdbcTemplate.query("select * from member",new BeanPropertyRowMapper<>(Member.class));
    }

//    public static List mapToList(Map map){
//        List list=new ArrayList();
//        Iterator it=map.keySet().iterator();
//        while(it.hasNext()){
//            String key=it.next().toString();
//            Member member = new Member();
//
//            list.add();
//        }
//        return list;
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
