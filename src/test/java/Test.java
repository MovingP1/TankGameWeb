import com.TG.mapper.NewsMapper;
import com.TG.mapper.UserGarageMapper;
import com.TG.mapper.UserMapper;
import com.TG.pojo.*;
import com.TG.service.NewsService;
import com.TG.service.StoreService;
import com.TG.service.UserService;
import com.TG.service.VideoService;
import com.TG.service.impl.NewsServiceImpl;
import com.TG.service.impl.StoreServiceImpl;
import com.TG.service.impl.UserServiceImpl;
import com.TG.service.impl.VideoServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    SqlSession sqlSession;
    //动态代理对象
    NewsMapper newsMapper;
    //日期格式化刷子
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void openSqlSession() throws IOException {
        //1读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3取出SqlSession
        sqlSession = factory.openSession();
        //取出动态代理对象，完成接口中方法的调用，实则是调用xml文件中相应标签的功能
        newsMapper = sqlSession.getMapper(NewsMapper.class);
    }
    @After
    public void closeSqlSession(){
        sqlSession.close();
    }

//    @org.junit.Test
//    public void testAddNews() throws ParseException {
//        int result = 0;
//        News news = new News(simpleDateFormat.parse("2022-09-06"),"TEST","FirstTest","Just test if it is work","nhb_frontline_2022_1920x900.jpeg","nothing new here and 看看中文是否安好~ :)");
//        result = newsMapper.addNews(news);
//        sqlSession.commit();
//
//        System.out.println(result);
//    }
//    @org.junit.Test
//    public void testAddNews2() throws ParseException, IOException {
//        int result = 0;
//        News news = new News(simpleDateFormat.parse("2022-09-15"),"TEST","FirstTest","Just test if it is work","nhb_frontline_2022_1920x900.jpeg","nothing new here and 看看中文是否安好~ :)");
//
//        NewsService service = new NewsServiceImpl();
//        result = service.addNews(news);
//
//        System.out.println(result);
//    }
//    @org.junit.Test
//    public void testGet7() throws ParseException, IOException {
//        List<News> newsList = new ArrayList<>();
//        NewsService service = new NewsServiceImpl();
//        newsList = service.getTop7();
//
//        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
//        String jsonStr = JSON.toJSONString(newsList, SerializerFeature.WriteDateUseDateFormat);
//
//        System.out.println(jsonStr);
//    }
//    @org.junit.Test
//    public void testGetById() throws ParseException, IOException {
//        NewsService service = new NewsServiceImpl();
//        List<News> newsList = service.getById(11);
//
//        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
//        String jsonStr = JSON.toJSONString(newsList, SerializerFeature.WriteDateUseDateFormat);
//        System.out.println(jsonStr);
//    }
//
//    @org.junit.Test
//    public void testAddVideo() throws IOException {
//        VideoService service = new VideoServiceImpl();
//        int result = service.addVideo(new Videos(null,"坦克世界为什么不加入11级车？","https://i1.hdslb.com/bfs/archive/d571b208a982f970d6ff51f25717c2f4330bf1fc.jpg@336w_190h_1c_!web-rec-list.webp","https://www.bilibili.com/video/BV1wY4y1c79T/?spm_id_from=333.788.recommend_more_video.4"));
//    }
//    @org.junit.Test
//    public void testGetVideo7() throws IOException {
//        VideoService service = new VideoServiceImpl();
//        List<Videos> videosList = service.videoList();
//
//        System.out.println(videosList);
//    }
//    @org.junit.Test
//    public void testGetStore() throws IOException {
//        StoreService service = new StoreServiceImpl();
//        List<Store> storeList = service.getAll();
//        System.out.println(storeList);
//    }
//    @org.junit.Test
//    public void testgetById() throws IOException {
//        StoreService service = new StoreServiceImpl();
//        List<Store> itemList = service.getItemById(Integer.valueOf(8));
//        System.out.println(itemList);
//    }
//
//    @org.junit.Test
//    public void testAddUser() throws ParseException {
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        String registDate = simpleDateFormat.format(new Date());
//        User user = new User(null,"user002","123123@123.com","112233",0,0,0,0,simpleDateFormat.parse(registDate),false);
//        userMapper.addUser(user);
//        sqlSession.commit();
//    }
//    @org.junit.Test
//    public void testGetOldPassword(){
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = new User("2","123456789");
//        int result = userMapper.selectOldPassword(user);
//        System.out.println(result);
//    }
//    @org.junit.Test
//    public void testUpdatePassword() throws ParseException {
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = new User("","12322222222");
//        int result = userMapper.changePassword(user);
//        sqlSession.commit();
//        System.out.println(result);
//    }
//    @org.junit.Test
//    public void testFindUserById(){
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findUserById(2);
//        System.out.println(userList);
//    }
//    @org.junit.Test
//    public void testFindUserByName(){
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.findUserByName("user009");
//
//        System.out.println(userList.isEmpty());
//    }
////    @org.junit.Test
////    public void testUpdateUserName(){
////        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////        List<User> user = userMapper.findUserById(2);
////        User user1 = user.get(0);
////        user1.setUser_name("user009");
////        int result = userMapper.changeUserName(user1);
////        sqlSession.commit();
////        System.out.println(result);
////    }
//
//    @org.junit.Test
//    public void testAddUserGarage(){
//        UserGarageMapper userGarageMapper = sqlSession.getMapper(UserGarageMapper.class);
//        UserGarage userGarage = new UserGarage(null,2,3,0);
//        int result = userGarageMapper.add(userGarage);
//        sqlSession.commit();
//        System.out.println(result);
//    }
//    @org.junit.Test
//    public void testFindUserGarageByUserId(){
//        UserGarageMapper userGarageMapper = sqlSession.getMapper(UserGarageMapper.class);
//        List<UserGarage> userGarageList = userGarageMapper.getGarageByUserId(2);
//        userGarageList.forEach(userGarage -> {
//            System.out.println(userGarage);
//        });
//    }
//
//    @org.junit.Test
//    public void testGetUserInfoPage() throws IOException {
//        UserService service = new UserServiceImpl();
//        //List<UserInfoPage> userInfoPageList = service.getAllUserInfo(new User("453453@qq.com","123"));
//        List<UserInfoPage> userInfoPageList = service.getAllUserInfo(new User("123123@123.com","112233"));
//        System.out.println(userInfoPageList);
//    }
    @org.junit.Test
    public void testFloat() throws IOException {
        float winAvg;
        UserService service = new UserServiceImpl();
        List<UserInfoPage> userInfoPageList = service.getAllUserInfo(new User("123123@123.com","112233"));
        winAvg = userInfoPageList.get(0).getTotalWinAvg();
        System.out.println((float)Math.round(winAvg*100)/100);
    }
}
