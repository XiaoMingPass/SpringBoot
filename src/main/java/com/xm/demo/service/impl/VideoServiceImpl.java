package com.xm.demo.service.impl;

import com.xm.demo.domain.Video;
import com.xm.demo.mapper.IVideoMapper;
import com.xm.demo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired
    private IVideoMapper videoMapper;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int update(Video video) {
       return videoMapper.update(video);
    }

    @Override
    public int delete(int id) {
        return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {
        return videoMapper.save(video);
    }
}
