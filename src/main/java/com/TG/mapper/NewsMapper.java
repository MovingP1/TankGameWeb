package com.TG.mapper;

import com.TG.pojo.News;
import java.util.List;

public interface NewsMapper {
    int addNews(News news);
    //查询所有的前七个新闻
    List<News> getTop7();
    //根据id查询新闻
    List<News> getById(int id);
}
