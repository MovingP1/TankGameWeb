package com.TG.pojo;

public class UserGarage {
    private Integer garage_id;
    private Integer user_id;
    private Integer tank_id;
    private Integer tank_exp;

    @Override
    public String toString() {
        return "User_Garage{" +
                "garage_id=" + garage_id +
                ", user_id=" + user_id +
                ", tank_id=" + tank_id +
                ", tank_exp=" + tank_exp +
                '}';
    }

    public Integer getGarage_id() {
        return garage_id;
    }

    public void setGarage_id(Integer garage_id) {
        this.garage_id = garage_id;
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

    public Integer getTank_exp() {
        return tank_exp;
    }

    public void setTank_exp(Integer tank_exp) {
        this.tank_exp = tank_exp;
    }

    public UserGarage(Integer garage_id, Integer user_id, Integer tank_id, Integer tank_exp) {
        this.garage_id = garage_id;
        this.user_id = user_id;
        this.tank_id = tank_id;
        this.tank_exp = tank_exp;
    }

    public UserGarage(Integer user_id, Integer tank_id) {
        this.user_id = user_id;
        this.tank_id = tank_id;
    }

    public UserGarage() {
    }
}
