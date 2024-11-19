package com.TG.pojo;

public class UserInfoPage {
    private Integer user_id;
    private Integer tank_id;
    private Integer totalTimes;
    private float totalWinAvg;
    private float tankWinAvg;
    private float tankDamageAverage;
    private float tankExpAverage;
    private Integer tankTotalTimes;
    private String tank_name;
    private User user;

    @Override
    public String toString() {
        return "UserInfoPage{" +
                "user_id=" + user_id +
                ", tank_id=" + tank_id +
                ", totalTimes=" + totalTimes +
                ", totalWinAvg=" + totalWinAvg +
                ", tankWinAvg=" + tankWinAvg +
                ", tankDamageAverage=" + tankDamageAverage +
                ", tankExpAverage=" + tankExpAverage +
                ", tankTotalTimes=" + tankTotalTimes +
                ", tank_name='" + tank_name + '\'' +
                ", user=" + user +
                '}';
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

    public Integer getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Integer totalTimes) {
        this.totalTimes = totalTimes;
    }

    public float getTotalWinAvg() {
        return totalWinAvg;
    }

    public void setTotalWinAvg(float totalWinAvg) {
        this.totalWinAvg = totalWinAvg;
    }

    public float getTankWinAvg() {
        return tankWinAvg;
    }

    public void setTankWinAvg(float tankWinAvg) {
        this.tankWinAvg = tankWinAvg;
    }

    public float getTankDamageAverage() {
        return tankDamageAverage;
    }

    public void setTankDamageAverage(float tankDamageAverage) {
        this.tankDamageAverage = tankDamageAverage;
    }

    public float getTankExpAverage() {
        return tankExpAverage;
    }

    public void setTankExpAverage(float tankExpAverage) {
        this.tankExpAverage = tankExpAverage;
    }

    public Integer getTankTotalTimes() {
        return tankTotalTimes;
    }

    public void setTankTotalTimes(Integer tankTotalTimes) {
        this.tankTotalTimes = tankTotalTimes;
    }

    public String getTank_name() {
        return tank_name;
    }

    public void setTank_name(String tank_name) {
        this.tank_name = tank_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfoPage(Integer user_id, Integer tank_id, Integer totalTimes, float totalWinAvg, float tankWinAvg, float tankDamageAverage, float tankExpAverage, Integer tankTotalTimes, String tank_name, User user) {
        this.user_id = user_id;
        this.tank_id = tank_id;
        this.totalTimes = totalTimes;
        this.totalWinAvg = totalWinAvg;
        this.tankWinAvg = tankWinAvg;
        this.tankDamageAverage = tankDamageAverage;
        this.tankExpAverage = tankExpAverage;
        this.tankTotalTimes = tankTotalTimes;
        this.tank_name = tank_name;
        this.user = user;
    }

    public UserInfoPage() {
    }
}
