package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Carousel;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        carouselService.delete(1);
    }
    @GetMapping("/giveID")
//    @PostMapping("/searchByID")
    public Carousel giveID(@RequestParam("id") Integer id){
        Carousel carousel;
        carousel = carouselService.searchById(id);
        return carousel;
    }

//    @GetMapping("/DeleteID")
//    public List<Carousel> deleteID(@RequestParam("id") Integer id){
//        carouselService.delete(id);
////        return findAll();
//    }

    @RequestMapping(value = "/AddID",method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
//    @GetMapping("/AddID")
    public void InsertID(@RequestBody Carousel carousel){
        carouselService.insert(carousel);
    }

    //获取分页数据
    @GetMapping("/getPageData")
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return carouselService.getPageList(page, limit);
    }
}
