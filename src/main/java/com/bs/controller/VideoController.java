package com.bs.controller;

import com.bo.Video;
import com.bs.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        Assert.notNull(videoService, "videoService no debe ser null");
        this.videoService = videoService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Video>> listaVideo() {
        return new ResponseEntity<>(videoService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Video> findOne(@PathVariable("id") int id) {
        return new ResponseEntity<>(videoService.findOne(id), HttpStatus.OK);
    }
}