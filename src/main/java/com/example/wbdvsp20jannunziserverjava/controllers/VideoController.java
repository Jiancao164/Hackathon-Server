package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Video;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.VideoService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class VideoController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    VideoService videoService;



    @PostMapping("/api/videos")
    public Video createVideo(@RequestBody String video) {
        return videoService.createVideo();
    }

    @DeleteMapping("/api/videos/{vid}")
    public int deleteVideo(@PathVariable Integer vid) {
        return videoService.deleteVideo(vid);
    }

    @GetMapping("/api/videos")
    public List<Video> findVideos() {
        return videoService.findVideos();
    }
    @GetMapping("/api/videos/{vid}")
    public Video findVideoById(@PathVariable Integer vid) {
        return videoService.findVideoById(vid);
    }
    @PutMapping("/api/videos/{vid}")
    public Video updateVideo(@PathVariable Integer vid, @RequestBody Video video) {
        return videoService.updateVideo(vid, video);
    }

}
