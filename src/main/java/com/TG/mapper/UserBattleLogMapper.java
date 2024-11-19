package com.TG.mapper;

import com.TG.pojo.UserBattleLog;
import com.TG.pojo.UserBattleLogAfter;

import java.util.List;

public interface UserBattleLogMapper {
    //根据用户id获取所有战斗日志
    List<UserBattleLog> getAllLog(int user_id);

    List<UserBattleLogAfter> getAfterLog(int user_id);
    //获取总场次信息
    int getAllTimes(int user_id);
    int getAllLoseTimes(int user_id);
    //根据坦克id获取场次信息
    int getTankAllTimes(UserBattleLog twoId);
    int getTankLoseTimes(UserBattleLog twoId);

    //获取总伤害
    int getAllDam(int user_id);
}
