package com.bs.service.impl;

import com.bo.Video;
import com.bs.service.VideoService;
import com.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        Assert.notNull(videoRepository, "videoRepository no debe ser null");
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video findOne(Integer id) {
        return videoRepository.findOne(id);
    }
}