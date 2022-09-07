package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository {

    void saveVideo(Long lessonId, Video video);

    void updateVideo(Long id,Video video);

    Video getVideoById(Long id);

    List<Video> getAllVideos(Long id);

    void deleteVideoById(Long id);
}