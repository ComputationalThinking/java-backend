package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService userService;
    @GetMapping("/memberFindAll")
    public List<Member> findAll(){
        List<Member> list =userService.findAll();
        return list;
    }
    @GetMapping("/memberFindByCondition")
    public List<Object> findByCondition(){
        List<Object> list =userService.findByCondition("identity","1");
        return list;
    }
    @GetMapping("/memberUpdate")
    public void update(){
        Member member=new Member();
        member.setIdentity(0);
        member.setArea(1);
        member.setContent("JJLin");
        member.setEmail("145******");
        member.setTel("1111");
        member.setName("臭牛津");
        member.setId(4);
        member.setRole("老师");
        member.setImg("adfasdfasdfasdfa");
        userService.update(member);
    }
    @GetMapping("/memberDelete")
    public void delete(){
        Member member=new Member();
        member.setId(10);
        userService.delete(member);
    }
    @GetMapping("/memberInsert")
    public void insert(){
        Member member=new Member();
        member.setIdentity(0);
        member.setArea(1);
        member.setContent("JJLin");
        member.setEmail("145******");
        member.setTel("1111");
        member.setName("学生8");
        member.setId(10);
        member.setRole("老师");
        member.setImg("dadfasdfasdf");
        userService.insert(member);
    }
}
