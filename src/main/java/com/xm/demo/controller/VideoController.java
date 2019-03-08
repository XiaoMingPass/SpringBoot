package com.xm.demo.controller;

import com.xm.demo.domain.Video;
import com.xm.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService VideoService;

    @GetMapping("page")
    public Object pageVideo(){
        return VideoService.findAll();
    }

    @GetMapping("find_by_Id")
    public Object findById(int id){
        return VideoService.findById(id);
    }

    @DeleteMapping("del_by_id")
    public int deleteById(int id){
        return VideoService.delete(id);
    }

    @PutMapping("update_by_id")
    public int update(int id , String title){
        Video video = new Video();
        video.setId(id);
        video.setTitle(title);
        return VideoService.update(video);
    }

    @PostMapping("update_by_id")
    public int update(String title){
        Video video = new Video();
        video.setTitle(title);
        return VideoService.save(video);
    }




}
