package com.TG.service;

import com.TG.pojo.Videos;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    int addVideo(Videos videos) throws IOException;
    List<Videos> videoList() throws IOException;
}
