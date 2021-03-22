package com.example.project_.markerhub.controller;


import com.example.project_.markerhub.entity.Carousel;
import com.example.project_.markerhub.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @GetMapping("/findeall")
    public List<Carousel> findALL(){
        return carouselService.findALL();
    }

    @GetMapping("/insert")
    public void insert(){
        Carousel carousel = new Carousel();
        carousel.setPage(2);
        carousel.setPic("adsdsdsdasd");
        carouselService.insert(carousel);
    }

    @GetMapping("/update")
    public void update(){
        Carousel carousel = new Carousel();
        carousel.setPage(2);
        carousel.setPic("我是路径");
        carousel.setId(1);
        carouselService.update(carousel);
    }

    @GetMapping("/delete")
    public void delete(){
        Carousel carousel = new Carousel();
        carousel.setPage(3);
        carousel.setPic("adasdasd");
        carouselService.delete(3);
    }
}
