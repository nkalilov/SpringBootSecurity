package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Video;

import java.util.List;

public interface VideoService {

    void saveVideo(Long lessonId, Video video);

    void updateVideo(Long id,Video video);

    Video getVideoById(Long id);

    List<Video> getAllVideos(Long id);

    void deleteVideoById(Long id);
}
