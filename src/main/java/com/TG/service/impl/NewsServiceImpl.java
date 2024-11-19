package com.TG.service.impl;

import com.TG.mapper.NewsMapper;
import com.TG.pojo.News;
import com.TG.service.NewsService;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsServiceImpl implements NewsService{
    SqlSession sqlSession;
    NewsMapper newsMapper;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    private void openSqlSession() throws IOException {
        //1读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3取出SqlSession
        sqlSession = factory.openSession();
        //取出动态代理对象，完成接口中方法的调用，实则是xml文件中相应标签的功能
        newsMapper = sqlSession.getMapper(NewsMapper.class);
    }

    public int addNews(News news) throws IOException {
        openSqlSession();
        int result = 0;

        result = newsMapper.addNews(news);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public List<News> getTop7() throws IOException {
        openSqlSession();
        List<News> newsList = newsMapper.getTop7();

        sqlSession.close();
        return newsList;
    }

    @Override
    public List<News> getById(int id) throws IOException {
        openSqlSession();
        List<News> newsList = newsMapper.getById(id);

        sqlSession.close();
        return newsList;
    }

}
