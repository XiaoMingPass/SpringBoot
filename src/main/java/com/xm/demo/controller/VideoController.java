package com.xm.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.demo.domain.Video;
import com.xm.demo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private IVideoService VideoService;

    /**
     * 分页
     * @param curPage
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    public Object pageVideo(@RequestParam(value = "cur_page",defaultValue = "1")int curPage,
                            @RequestParam(value = "page_size",defaultValue = "10")int pageSize){
        PageHelper.startPage(curPage,pageSize);
        List<Video> list = VideoService.findAll();
        PageInfo<Video> pageinfo = new PageInfo<>(list);

        Map<String,Object> data = new HashMap<>();
        data.put("total_size",pageinfo.getTotal());
        data.put("total_page",pageinfo.getPages());
        data.put("page_size",pageinfo.getPageSize());
        data.put("current_page",curPage);
        data.put("data",pageinfo.getList());

        return data;
    }

    /**
     * 根据id查询视频
     * @param videoId
     * @return
     */
    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value = "video_id",required = true) int videoId){
        return VideoService.findById(videoId);
    }
}
