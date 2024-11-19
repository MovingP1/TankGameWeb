package com.TG.service.impl;

import com.TG.mapper.AllTanksMapper;
import com.TG.mapper.UserBattleLogMapper;
import com.TG.mapper.UserGarageMapper;
import com.TG.mapper.UserMapper;
import com.TG.pojo.*;
import com.TG.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    SqlSession sqlSession;
    UserMapper userMapper;
    private void openSqlSession() throws IOException {
        //1读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //3取出SqlSession
        sqlSession = factory.openSession();
        //取出动态代理对象，完成接口中方法的调用，实则是xml文件中相应标签的功能
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public int registUser(User user) throws IOException {
        openSqlSession();
        int result=0;
        String email = user.getUser_EmailAddr();
        //注册前查询邮箱是否被用过
        int emailIsUsed = userMapper.emailIsUsed(email);

        if (emailIsUsed == 0){
             result = userMapper.addUser(user);
             sqlSession.commit();
        }

        sqlSession.close();
        return result;
    }

    @Override
    public int login(User user) throws IOException {
        openSqlSession();
        int result = userMapper.selectOldPassword(user);
        sqlSession.close();
        return result;
    }

    @Override
    public List<User> findUserByEmail(User user) throws IOException {
        openSqlSession();
        List<User> userList = userMapper.findUserByEmail(user);
        sqlSession.close();
        return userList;
    }

    @Override
    public List<User> findUserByName(String username) throws IOException {
        openSqlSession();
        List<User> userList = userMapper.findUserByName(username);
        sqlSession.close();
        return userList;
    }

    @Override
    public int checkEmail(String email) throws IOException {
        openSqlSession();
        int emailIsUsed = 0;
        if (email != null){
            emailIsUsed = userMapper.emailIsUsed(email);
        }
        sqlSession.close();
        return emailIsUsed;
    }

    @Override
    public List<UserInfoPage> getAllUserInfo(User user) throws IOException {
        int totalTimes=0,totalLoseTimes=0,tankTotalTimes=0,tankTotalLoseTimes=0,tank_id=0;
        float totalWinAvg=0,tankWinAvg=0,tankDamageAverage=0,tankExpAverage=0,User_PremiumDay=0;
        String tank_name="";
        List<UserInfoPage> userInfoPageList = new ArrayList<>();
        List<UserBattleLogAfter> twoAvgList = new ArrayList<>();

        openSqlSession();
        //先获取用户基础信息
        List<User> userList = userMapper.findUserByEmail(user);
        User user1 = userList.get(0);
        //根据用户id查询战斗日志
        Integer user_id = userList.get(0).getUser_id();
        UserBattleLogMapper userBattleLogMapper = sqlSession.getMapper(UserBattleLogMapper.class);
        AllTanksMapper allTanksMapper = sqlSession.getMapper(AllTanksMapper.class);

        //获取平均经验和平均伤害，计算胜率
        /*存储类型UserBattleLogAfter(Integer tank_id,damageAverage,expAverage)*/
        if (userBattleLogMapper.getAfterLog(user_id) != null){
            twoAvgList = userBattleLogMapper.getAfterLog(user_id);
            totalTimes = userBattleLogMapper.getAllTimes(user_id);
            totalLoseTimes = userBattleLogMapper.getAllLoseTimes(user_id);
        }

        //计算胜率
        if (totalLoseTimes != 0 && totalTimes != 0){
            //float num=(float)(Math.round(totalPrice*100)/100)
            float num = (float)totalLoseTimes/(float)totalTimes;
//            totalWinAvg = (float)(Math.round(num*10000)/100);
            totalWinAvg = (float)Math.round(num*10000)/100;
        }
        //计算高涨天数
        if (user1.getUser_PremiumMin() != 0){
            User_PremiumDay = ((float)user1.getUser_PremiumMin()/60)/24;
            user1.setUser_PremiumMin((int) User_PremiumDay);
        }

        if (twoAvgList.size() == 0){
            //没战斗日志的用户直接组合
            UserInfoPage userInfoPage = new UserInfoPage(user_id,tank_id,totalTimes,totalWinAvg,tankWinAvg,tankDamageAverage,tankExpAverage,tankTotalTimes,tank_name,user1);
            userInfoPageList.add(userInfoPage);
        }else {
            for (int i=0; i<twoAvgList.size(); i++){
                float temp;
                //根据坦克id组合查询
                tank_id = twoAvgList.get(i).getTank_id();
                temp = twoAvgList.get(i).getExpAverage();
                tankExpAverage = (float)Math.round(temp*100)/100;
                tankDamageAverage = (float)Math.round(twoAvgList.get(i).getDamageAverage()*100)/100;
                tank_name = allTanksMapper.getTankName(tank_id);

                UserBattleLog userBattleLog = new UserBattleLog(user_id,tank_id);
                tankTotalTimes = userBattleLogMapper.getTankAllTimes(userBattleLog);
                tankTotalLoseTimes = userBattleLogMapper.getTankLoseTimes(userBattleLog);
                if (tankTotalLoseTimes != 0){
                    temp = ((float)tankTotalLoseTimes/(float)tankTotalTimes)*100;
                    //System.out.println("临时变量的值输出为======"+temp);0.33333334
//                    tankWinAvg = (float)(Math.round(temp*100)/100);
                    tankWinAvg = (float)Math.round(temp*100)/100;
                }

                //拿到所有数据之后组合
                UserInfoPage userInfoPage = new UserInfoPage(user_id,tank_id,totalTimes,totalWinAvg,tankWinAvg,tankDamageAverage,tankExpAverage,tankTotalTimes,tank_name,user1);
                userInfoPageList.add(userInfoPage);
            }
        }
        System.out.println(userInfoPageList);
        sqlSession.close();
        return userInfoPageList;
    }

    @Override
    public int getAllDam(int user_id) throws IOException {
        int allDam=0;
        openSqlSession();
        UserBattleLogMapper userBattleLogMapper = sqlSession.getMapper(UserBattleLogMapper.class);
        allDam =  userBattleLogMapper.getAllDam(user_id);
        sqlSession.close();
        return allDam;
    }

    @Override
    public int BuyTank(UserGarage userGarage) throws IOException {
        openSqlSession();
        UserGarageMapper userGarageMapper = sqlSession.getMapper(UserGarageMapper.class);
        int result = userGarageMapper.buyTank(userGarage);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public int checkTank(UserGarage userGarage) throws IOException {
        openSqlSession();
        UserGarageMapper userGarageMapper = sqlSession.getMapper(UserGarageMapper.class);
        int result = userGarageMapper.checkTank(userGarage);
        sqlSession.close();
        return result;
    }

    @Override
    public int buyGoldOrPrAccount(User user) throws IOException {
        openSqlSession();
        int result = userMapper.buyGoldOrPrAccount(user);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Override
    public int getPrMin(int userId) throws IOException {
        openSqlSession();
        int oldAcMin = userMapper.getOldPrAccountMin(userId);
        sqlSession.close();
        return oldAcMin;
    }

    @Override
    public int getOldGold(int userId) throws IOException {
        openSqlSession();
        int oldGold = userMapper.getOldGold(userId);
        return oldGold;
    }
}
