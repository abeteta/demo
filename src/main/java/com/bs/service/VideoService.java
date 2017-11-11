package com.bs.service;

import com.bo.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAll();
    Video findOne(Integer id);
}