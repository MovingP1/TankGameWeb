package com.TG.mapper;

import com.TG.pojo.UserGarage;
import java.util.List;

public interface UserGarageMapper {
    //添加车辆进入玩家车库
    int add(UserGarage userGarage);
    //根据玩家id获取车库信息
    List<UserGarage> getGarageByUserId(int user_id);
    //购买物品
    int buyTank(UserGarage userGarage);
    //查看是否有tank
    int checkTank(UserGarage userGarage);
}
