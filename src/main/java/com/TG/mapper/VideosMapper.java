package com.TG.mapper;

import com.TG.pojo.Videos;
import java.util.List;

public interface VideosMapper {
    int addVideos(Videos videos);
    //查询所有的前七个视频
    List<Videos> getTop7();
}
