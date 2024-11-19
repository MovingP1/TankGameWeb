package com.TG.service;

import com.TG.pojo.User;
import com.TG.pojo.UserGarage;
import com.TG.pojo.UserInfoPage;
import java.io.IOException;
import java.util.List;

public interface UserService {
    int registUser(User user) throws IOException;
    int login(User user) throws IOException;
    List<User> findUserByEmail(User user) throws IOException;
    List<User> findUserByName(String username) throws IOException;

    int checkEmail(String email) throws IOException;

    List<UserInfoPage> getAllUserInfo(User user) throws IOException;
    int getAllDam(int user_id) throws IOException;

    int BuyTank(UserGarage userGarage) throws IOException;
    int checkTank(UserGarage userGarage) throws IOException;
    int buyGoldOrPrAccount(User user) throws IOException;

    int getPrMin(int userId)throws IOException;
    int getOldGold(int userId)throws IOException;
}
