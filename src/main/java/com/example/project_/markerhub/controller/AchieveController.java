package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.Achieve;
import com.example.project_.markerhub.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/getdatacondition")
    public List<Achieve> getDataCondition(){
        List<Achieve> list = achieveService.findByCondition("真实");
        return list;
    }
//    @GetMapping("/delete")//按id号删除数据
//    public void delete(){
//        achieveService.delete(4);
//    }

    //    @GetMapping("/insert")
//    public void insert(){//增加数据
//        Achieve achieve = new Achieve();
//        achieve.setTitle("欧洲锦标冠军");
//        achieve.setContent("获得国际锦标赛的第一名");
//        achieve.setTime(LocalDateTime.of(2021,12,12,10,11,12));
//        achieve.setHot(1);
//        achieve.setParticipantMember("超级英雄");
//        achieve.setSort(0);
//        achieve.setAchieveName("锦标赛");
//        achieveService.insert(achieve);
//    }
    @GetMapping("/update")
    public void update(){//修改数据
        Achieve achieve = new Achieve();
        achieve.setId(1);
        achieve.setTitle("欧");
        achieve.setContent("获");
        achieve.setTime(LocalDateTime.of(2021,12,12,10,11,12));
        achieve.setHot(1);
        achieve.setParticipantMember("超");
        achieve.setSort(0);
        achieve.setAchieveName("锦");
        achieve.setImg("sdasdfasf");
        achieveService.update(achieve);
    }
}