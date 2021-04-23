package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/achieve")
public class AchieveController {
    @Autowired
    AchieveService achieveService;

    @GetMapping("/getdata")
    public List<Achieve> getData(){
        List<Achieve> list = achieveService.findALL();
        return list;
    }

    @GetMapping("/delete")//按id号删除数据
    public void delete(){
        achieveService.delete(4);
    }

//    @GetMapping("/insert")
//    public void insert(){//增加数据
//        Achieve achieve = new Achieve();
//        achieve.setTitle("欧洲锦标冠军");
//        achieve.setContent("获得国际锦标赛的第一名");
//        achieve.setTime(LocalDateTime.of(2021, 12, 12, 10, 11, 12));
//        achieve.setHot(1);
//        achieve.setParticipantMember("超级英雄");
//        achieve.setSort(0);
//        achieve.setAchieveName("锦标赛");
//        achieveService.insert(achieve);
//    }
//    @GetMapping("/update")
//    public void update(){//修改数据
//        Achieve achieve = new Achieve();
//        achieve.setId(1);
//        achieve.setTitle("欧");
//        achieve.setContent("获");
//        achieve.setTime(LocalDateTime.of(2021,12,12,10,11,12));
//        achieve.setHot(1);
//        achieve.setParticipantMember("超");
//        achieve.setSort(0);
//        achieve.setAchieveName("锦");
//        achieve.setImg("sdasdfasf");
//        achieveService.update(achieve);
//    }
    @GetMapping("/giveID")
    public Achieve giveID(@RequestParam("id") Integer id){
        Achieve achieve;
        achieve = achieveService.searchById(id);
        return achieve;
    }

    @GetMapping("/deleteID")//按id号删除数据
    public List<Achieve> deleteID(@RequestParam("id") Integer id){
        achieveService.delete(id);
        return getData();
    }
    @GetMapping("/getdata2")
    public List<Achieve> getdata2(){
        List<Achieve> list = achieveService.findByTitle("真实");
        return list;
    }
    @GetMapping("/getDataBySort")
    public List<Achieve> getDataBySort(@RequestParam Integer sort){
        List<Achieve> list = achieveService.findByCondition(sort);
        return list;
    }
    @GetMapping("/getDataByTitle")
    public List<Achieve> getDataByTitle(@RequestParam String title){
        List<Achieve> list = achieveService.findByTitle(title);
        return list;
    }
    @RequestMapping(value = "/updataID",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updateID(@RequestBody Achieve achieve){
        achieveService.update(achieve);
    }

    @RequestMapping(value = "/insertID",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void insertID(@RequestBody Achieve achieve){
        achieveService.insert(achieve);
    }

    @GetMapping("/getPageData")
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return achieveService.getPageList(page, limit);
    }
}