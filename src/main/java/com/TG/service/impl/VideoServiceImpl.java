package com.TG.service.impl;

import com.TG.mapper.VideosMapper;
import com.TG.pojo.Videos;
import com.TG.service.VideoService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class VideoServiceImpl implements VideoService {
    SqlSession sqlSession;
    VideosMapper videosMapper;

    private void openSqlSession() throws IOException {
        //1读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3取出SqlSession
        sqlSession = factory.openSession();
        //取出动态代理对象，完成接口中方法的调用，实则是xml文件中相应标签的功能
        videosMapper = sqlSession.getMapper(VideosMapper.class);
    }

    @Override
    public int addVideo(Videos videos) throws IOException {
        openSqlSession();
        int result = 0;
        result = videosMapper.addVideos(videos);

        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public List<Videos> videoList() throws IOException {
        openSqlSession();
        List<Videos> videosList = videosMapper.getTop7();
        sqlSession.close();

        return videosList;
    }
}
