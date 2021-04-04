package com.example.project_.markerhub.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.PageData;
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
    MemberService memberService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private BeanPropertyRowMapper<Member> MemberMapper = new BeanPropertyRowMapper<>(Member.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Object> getMapper(String sql){
        List message = new ArrayList();
        message = jdbcTemplate.query(sql,MemberMapper);
        return message;
    }
    //查询所有
    @Override
    public List<Member> findAll(){
        return jdbcTemplate.query("select * from member",new BeanPropertyRowMapper<>(Member.class));
    }

    //根据条件查询
    @Override
    public List<Object> findByCondition(String attribute,String key){
        String sql="SELECT * FROM  member"+" WHERE "+ attribute +" LIKE '%"+key+"%'";
        List message = getMapper(sql);
        return message;
    }
    //    //更新数据
    @Override
    public void update(Member member){
        String sql ="UPDATE member set name=?,identity=?,content=?,tel=?,email=?,role=?,area=?,img=? where id=?";
        jdbcTemplate.update(sql,member.getName(),member.getIdentity(),member.getContent(),member.getTel(),member.getEmail(),member.getRole(),member.getArea(),member.getImg(),member.getId());
    }
    //    //添加数据
    @Override
    public void insert(Member member){
        //String sql="insert into member values ("+id+",'"+name+"',"+identity+",'"+content+"','"+tel+"','"+email+"',"+area+",'"+role+"')";
        String sql="insert into member values (null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,member.getName(),member.getIdentity(),member.getContent(),member.getTel(),member.getEmail(),member.getRole(),member.getArea(),member.getImg());
    }
    //    //删除数据
    @Override
    public void delete(Integer id){
        String sql="delete from member where id=?";
        jdbcTemplate.update(sql,id);
    }
    @Override
    public Result getPageList(int pageNum, int pageSize) {
        IPage<Member> IPage = new Page<>(pageNum, pageSize);
        IPage<Member> page = memberService.page(IPage);
        int total = (int) page.getTotal();
        List<Member> records = page.getRecords();
        PageData<Member> objectPageData = new PageData(total, records);
        return Result.success(objectPageData);
    }
    @Override
    public Member searchById(Integer id){
        Member member;
        String sql = "select * from member where id=?";
        Object[] args = {id};
        int [] argTypes = {Types.INTEGER};
        member = jdbcTemplate.queryForObject(sql,args,argTypes,new BeanPropertyRowMapper<>(Member.class));
        return member;
    }
    @Override
    public List<Member> conditionSearch(String name){
        List<Member> list;
        String sql="select * from member where name like ?";
        Object[] args = {name};
        int[] argTypes={Types.VARCHAR};
        list = jdbcTemplate.query(sql,args,argTypes,new BeanPropertyRowMapper<>(Member.class));
        return list;
    }
}
