package com.TG.service;

import com.TG.pojo.News;
import java.io.IOException;
import java.util.List;

public interface NewsService {
    //增加新闻
    int addNews(News news) throws IOException;
    //查询所有的前七个新闻
    List<News> getTop7() throws IOException;
    //根据id查询新闻
    List<News> getById(int id) throws IOException;
}
