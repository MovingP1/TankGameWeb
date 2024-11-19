package com.TG.pojo;

public class UserBattleLog {
    private Integer log_id;
    private Integer user_id;
    private Integer tank_id;
    private boolean result;
    private Integer damage;
    private Integer exp;

    public UserBattleLog(Integer user_id, Integer tank_id, Integer damage) {
        this.user_id = user_id;
        this.tank_id = tank_id;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "UserBattleLog{" +
                "log_id=" + log_id +
                ", user_id=" + user_id +
                ", tank_id=" + tank_id +
                ", result=" + result +
                ", damage=" + damage +
                ", exp=" + exp +
                '}';
    }

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTank_id() {
        return tank_id;
    }

    public void setTank_id(Integer tank_id) {
        this.tank_id = tank_id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public UserBattleLog(Integer user_id, Integer tank_id) {
        this.user_id = user_id;
        this.tank_id = tank_id;
    }

    public UserBattleLog(Integer user_id, Integer tank_id, boolean result, Integer damage, Integer exp) {
        this.user_id = user_id;
        this.tank_id = tank_id;
        this.result = result;
        this.damage = damage;
        this.exp = exp;
    }

    public UserBattleLog(Integer log_id, Integer user_id, Integer tank_id, boolean result, Integer damage, Integer exp) {
        this.log_id = log_id;
        this.user_id = user_id;
        this.tank_id = tank_id;
        this.result = result;
        this.damage = damage;
        this.exp = exp;
    }

    public UserBattleLog() {
    }
}
