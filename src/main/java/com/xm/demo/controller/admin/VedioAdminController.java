package com.xm.demo.controller.admin;

import com.xm.demo.domain.Video;
import com.xm.demo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/v1/video")
public class VedioAdminController {
    @Autowired
    private IVideoService VideoService;

    /**
     * 删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("del_by_id")
    public int deleteById(@RequestParam(value = "video_id",required = true) int videoId){
        return VideoService.delete(videoId);
    }

    /**
     * 更新视频
     * @param video
     * @return
     */
    @PutMapping("update_by_id")
    public int update(@RequestBody Video video){
        return VideoService.update(video);
    }

    /**
     * 保存视频
     * @param video
     * @return
     */
    @PostMapping("save")
    public int save(@RequestBody Video video){
        return VideoService.save(video);
    }
}
