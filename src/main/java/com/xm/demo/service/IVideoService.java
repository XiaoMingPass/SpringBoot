package com.xm.demo.service;

import com.xm.demo.domain.Video;

import java.util.List;

public interface IVideoService {
    List<Video> findAll();

    Video findById(int id);

    int update(Video video);

    int delete(int id);

    int save(Video video);
}
