package com.example.project_.markerhub.service;

import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface MemberService extends IService<Member> {
    //查询所有
    List<Member> findAll();
    //查询单个
    List<Object> findByCondition(String attribute,String key);
    //    添加数据
    void insert(Member member);
    //    修改数据
    void update(Member member);
    //    删除数据
    void delete(Member member);
    //获取分页数据
    Result getPageList(int pageNum, int pageSize);
}
