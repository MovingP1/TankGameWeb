package com.TG.pojo;

import java.util.Date;

public class User {
    private Integer user_id;
    private String user_name;
    private String user_EmailAddr;
    private String user_password;
    private Integer user_coin;
    private Integer user_gold;
    private Integer user_exp;
    private Integer user_PremiumMin;
    private Date user_registDate;
    private Boolean is_boughtStarterPak;

    public User(Integer user_id, Integer user_gold, Integer user_PremiumMin) {
        this.user_id = user_id;
        this.user_gold = user_gold;
        this.user_PremiumMin = user_PremiumMin;
    }

    public User(String user_EmailAddr, String user_password) {
        this.user_EmailAddr = user_EmailAddr;
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_EmailAddr='" + user_EmailAddr + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_coin=" + user_coin +
                ", user_gold=" + user_gold +
                ", user_exp=" + user_exp +
                ", user_PremiumMin=" + user_PremiumMin +
                ", user_registDate=" + user_registDate +
                ", is_boughtStarterPak=" + is_boughtStarterPak +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_EmailAddr() {
        return user_EmailAddr;
    }

    public void setUser_EmailAddr(String user_EmailAddr) {
        this.user_EmailAddr = user_EmailAddr;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_coin() {
        return user_coin;
    }

    public void setUser_coin(Integer user_coin) {
        this.user_coin = user_coin;
    }

    public Integer getUser_gold() {
        return user_gold;
    }

    public void setUser_gold(Integer user_gold) {
        this.user_gold = user_gold;
    }

    public Integer getUser_exp() {
        return user_exp;
    }

    public void setUser_exp(Integer user_exp) {
        this.user_exp = user_exp;
    }

    public Integer getUser_PremiumMin() {
        return user_PremiumMin;
    }

    public void setUser_PremiumMin(Integer user_PremiumMin) {
        this.user_PremiumMin = user_PremiumMin;
    }

    public Date getUser_registDate() {
        return user_registDate;
    }

    public void setUser_registDate(Date user_registDate) {
        this.user_registDate = user_registDate;
    }

    public Boolean getIs_boughtStarterPak() {
        return is_boughtStarterPak;
    }

    public void setIs_boughtStarterPak(Boolean is_boughtStarterPak) {
        this.is_boughtStarterPak = is_boughtStarterPak;
    }

    public User() {
    }

    public User(Integer user_id, String user_name, String user_EmailAddr, String user_password, Integer user_coin, Integer user_gold, Integer user_exp, Integer user_PremiumMin, Date user_registDate, Boolean is_boughtStarterPak) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_EmailAddr = user_EmailAddr;
        this.user_password = user_password;
        this.user_coin = user_coin;
        this.user_gold = user_gold;
        this.user_exp = user_exp;
        this.user_PremiumMin = user_PremiumMin;
        this.user_registDate = user_registDate;
        this.is_boughtStarterPak = is_boughtStarterPak;
    }
}
