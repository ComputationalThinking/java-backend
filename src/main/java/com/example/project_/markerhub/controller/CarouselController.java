package com.example.project_.markerhub.controller;


import com.example.project_.common.lang.Result;
import com.example.project_.markerhub.entity.Carousel;
import com.example.project_.markerhub.entity.Member;
import com.example.project_.markerhub.entity.News;
import com.example.project_.markerhub.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    CarouselService carouselService;

    String url="";

    @GetMapping("/findall")
    public List<Carousel> findAll(){
        List<Carousel> list=carouselService.findALL();
        return list;
    }

    @GetMapping("/insert")
    public void insert(){
        Carousel carousel = new Carousel();
        carousel.setPage(2);
        carousel.setPic("adsdsdsdasd");
        carousel.setContent("adsd");
        carouselService.insert(carousel);
    }

    @GetMapping("/update")
    public void update(){
        Carousel carousel = new Carousel();
        carousel.setPage(2);
        carousel.setPic("我是路径");
        carousel.setId(1);
        carousel.setContent("我是描述");
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
    public Carousel giveID(@RequestParam("id") Integer id){
        Carousel carousel;
        carousel = carouselService.searchById(id);
        return carousel;
    }

    @GetMapping("/DeleteID")
    public List<Carousel> deleteID(@RequestParam("id") Integer id){
        carouselService.delete(id);
        return findAll();
    }

    @RequestMapping(value = "UpdataID",method = RequestMethod.POST,
            produces={MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void updateID(@RequestBody Carousel carousel){
        carousel.setPic(url);
        carouselService.update(carousel);
    }

    @RequestMapping(value = "/AddID",method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void InsertID(@RequestBody Carousel carousel){
        carousel.setPic(url);
        carouselService.insert(carousel);
    }

//    @RequestMapping(value = "/AddImg",method = RequestMethod.POST,
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody

    @PostMapping("/AddImg")
    public void InsertID(@RequestParam("file") MultipartFile file) {
        String path = System.getProperty("user.dir");
        String fileName = file.getOriginalFilename();
        String fileName1 = fileName.split("\\.")[1];
        UUID uuid=UUID.randomUUID();
        String name = uuid.toString(); // 随机的uuid
        File dest = new File(path + "\\src\\main\\java\\com\\example\\project_\\markerhub\\Image\\"+name + "." + fileName1);
        try {
            file.transferTo(dest);
        }catch (IOException e){
            System.out.print(e);
        }
        url = "\\src\\main\\java\\com\\example\\project_\\markerhub\\Image" + name + "." + fileName1;
    }

    //获取分页数据
    @GetMapping("/getPageData")
    @ResponseBody
    public Result getPageList(@RequestParam int page, @RequestParam int limit) {
        return carouselService.getPageList(page, limit);
    }
}
