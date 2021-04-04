package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
        userService.update(member);
    }
    @GetMapping("/memberDelete")
    public void delete(){
        Member member=new Member();
        member.setId(10);
        userService.delete(1);
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
        userService.insert(member);
    }
    @GetMapping("/memberSearch")
    public List<Member> search(){
        String name = "";
        List<Member> list = userService.conditionSearch("%"+name+"%");
        return list;
    }
    @GetMapping("/memberGiveID")
    public Member giveID(@RequestParam("id") Integer id){
        Member member;
        member = userService.searchById(id);
        return member;
    }
    @GetMapping("/memberDeleteID")
    public List<Member> deleteID(@RequestParam("id") Integer id){
        userService.delete(id);
        return findAll();
    }

    @RequestMapping(value = "/memberUpdataID",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updateID(@RequestBody Member member){
        userService.update(member);
    }

    @RequestMapping(value = "/memberAddID",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void InsertID(@RequestBody Member member){
        userService.insert(member);
    }

    @GetMapping("/getPageData")
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return userService.getPageList(page, limit);
    }
}
