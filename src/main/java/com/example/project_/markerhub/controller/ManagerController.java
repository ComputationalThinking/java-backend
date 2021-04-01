package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.ManagerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService userService;
    //查询数据
    @GetMapping("/information")
    public List<Manager> find(){
        List<Manager> list =userService.findAll();
        return list;
    }
    //插入数据
    @GetMapping("/insertData")
    public void insert(@RequestParam String name,@RequestParam String password) throws SQLException {
        userService.insert(name,password);
    }
    //删除数据
    @GetMapping("/deleteData")
    public void delete(@RequestParam Integer id){
        userService.delete(id);
    }
    //更新单个数据
    @GetMapping("/updateData")
    public void update(@RequestParam String attribute,@RequestParam String value,@RequestParam Integer id){
        userService.update(attribute,value,id);
    }
    //更新所有数据
    @GetMapping("/updateDataAll")
    public void updateAll(@RequestParam String username,@RequestParam String password,@RequestParam Integer id){
        userService.updateAll(username,password,id);
    }
    //查询数据
    @GetMapping("/searchData")
    public List<Manager> search(@RequestParam String attribute,@RequestParam String key){
        return userService.findByCondition(attribute, key);
    }
    //获取分页数据
    @GetMapping("/getPageData")
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return userService.getPageList(page, limit);

    }
}
