package com.TG.pojo;

public class UserBattleLogAfter {
    private Integer tank_id;
    private Integer totalTimes;
    private float winAverage;
    private float damageAverage;
    private float expAverage;

    @Override
    public String toString() {
        return "UserBattleLogAfter{" +
                "tank_id=" + tank_id +
                ", totalTimes=" + totalTimes +
                ", winAverage=" + winAverage +
                ", damageAverage=" + damageAverage +
                ", expAverage=" + expAverage +
                '}';
    }

    public UserBattleLogAfter(Integer tank_id, float damageAverage, float expAverage) {
        this.tank_id = tank_id;
        this.damageAverage = damageAverage;
        this.expAverage = expAverage;
    }

    public Integer getTank_id() {
        return tank_id;
    }

    public void setTank_id(Integer tank_id) {
        this.tank_id = tank_id;
    }

    public Integer getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Integer totalTimes) {
        this.totalTimes = totalTimes;
    }

    public float getWinAverage() {
        return winAverage;
    }

    public void setWinAverage(float winAverage) {
        this.winAverage = winAverage;
    }

    public float getDamageAverage() {
        return damageAverage;
    }

    public void setDamageAverage(float damageAverage) {
        this.damageAverage = damageAverage;
    }

    public float getExpAverage() {
        return expAverage;
    }

    public void setExpAverage(float expAverage) {
        this.expAverage = expAverage;
    }

//    public UserBattleLogAfter(Integer tank_id, Integer totalTimes, float winAverage, float damageAverage, float expAverage) {
//        this.tank_id = tank_id;
//        this.totalTimes = totalTimes;
//        this.winAverage = winAverage;
//        this.damageAverage = damageAverage;
//        this.expAverage = expAverage;
//    }

    public UserBattleLogAfter() {
    }
}
