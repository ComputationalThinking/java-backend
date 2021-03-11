package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.Manager;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerService userService;
    @GetMapping("/information")
    public List<Manager> find(){
        List<Manager> list =userService.findAll();
        return list;
    }
}
