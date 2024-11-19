package com.TG.mapper;

import com.TG.pojo.User;

import java.util.List;

public interface UserMapper {
    //注册账号
    int addUser(User user);
    //查询原密码
    int selectOldPassword(User user);
    //查询用户
    List<User> findUserById(int id);
    List<User> findUserByName(String name);
    List<User> findUserByEmail(User user);

    int emailIsUsed(String email);

    //修改密码
    int changePassword(User user);
    //修改账户名
    int changeUserName(User user);
    //修改高涨天数和金币
    int buyGoldOrPrAccount(User user);
    //获取原本账号高涨天数
    int getOldPrAccountMin(int userId);
    //获取原本账号的金币
    int getOldGold(int userId);
}
