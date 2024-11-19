package com.TG.service.impl;

import com.TG.mapper.AllTanksMapper;
import com.TG.mapper.StoreMapper;
import com.TG.pojo.Store;
import com.TG.service.StoreService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    SqlSession sqlSession;
    StoreMapper storeMapper;
    private void openSqlSession() throws IOException {
        //1读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3取出SqlSession
        sqlSession = factory.openSession();
        //取出动态代理对象，完成接口中方法的调用，实则是xml文件中相应标签的功能
        storeMapper = sqlSession.getMapper(StoreMapper.class);
    }

    @Override
    public List<Store> getAll() throws IOException {
        openSqlSession();
        List<Store> storeList = storeMapper.getAll();
        sqlSession.close();
        return storeList;
    }

    @Override
    public List<Store> getItemById(int id) throws IOException {
        openSqlSession();
        List<Store> storeList = storeMapper.getItemById(id);
        sqlSession.close();
        return storeList;
    }

    @Override
    public int getTankIdByName(String name) throws IOException {
        openSqlSession();
        AllTanksMapper allTanksMapper = sqlSession.getMapper(AllTanksMapper.class);
        int tankId = allTanksMapper.getTankIdByName(name);
        sqlSession.close();
        return tankId;
    }

    @Override
    public int getGoldPrice(int itemId) throws IOException {
        openSqlSession();
        int gold = storeMapper.getGoldPrice(itemId);
        sqlSession.close();
        return gold;
    }

    @Override
    public int getAttribute(int itemId) throws IOException {
        openSqlSession();
        int attribute = storeMapper.getAttribute(itemId);
        sqlSession.close();
        return attribute;
    }
}
