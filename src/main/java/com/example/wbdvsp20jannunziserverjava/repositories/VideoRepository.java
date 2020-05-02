package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository
        extends CrudRepository<Video, Integer> {

    @Query("SELECT video FROM Video video WHERE video.id=:vid")
    public Video findVideoById(
            @Param("vid") int vid);

    @Query("select video from Video video")
    public List<Video> findVideos();


//    @Query("select video from Video video where video.user.id=:mid")
//    public List<Video> findAllVideos(
//            @Param("mid") String moduleId);


}