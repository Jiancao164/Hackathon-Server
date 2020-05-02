package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Video;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.VideoRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoRepository videoRepository;

    public List<Video> findVideos() {
        return videoRepository.findVideos();
    }

    public Video createVideo() {
        Video video = new Video();
        video.setTitle("new video");
        video.setUrl("");
        video.setDescription("");
        return videoRepository.save(video);
    }

    public Video findVideoById(int vid) {
        return videoRepository.findVideoById(vid);
    }

    public Video updateVideo(int vid, Video video) {
        Video video1 = videoRepository.findVideoById(vid);
        video1.setTitle(video.getTitle());
        video1.setUrl(video.getUrl());
        video1.setDescription(video.getDescription());
        return videoRepository.save(video1);
    }



    public int deleteVideo(int vid) {
        videoRepository.deleteById(vid);
        return 1;
    }


}