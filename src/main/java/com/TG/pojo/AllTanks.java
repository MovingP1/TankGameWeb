package com.TG.pojo;

public class AllTanks {
    private Integer tank_id;
    private String tank_name;
    private String tank_type;
    private Integer tank_Hp;
    private Integer tank_MaxSpeed;
    private Integer tank_turretRotateSpeed;
    private float tank_reloadTime;
    private Integer tank_frontArm;
    private Integer tank_sideArm;
    private Integer tank_topArm;
    private Integer tank_backArm;
    private Integer tank_shell01_Damage;
    private Integer tank_shell01_penetrate;
    private Integer tank_shell02_Damage;
    private Integer tank_shell02_penetrate;
    private Integer gun_shell_Damage;
    private Integer gun_shell_penetrate;
    private Integer tank_needExp;
    private String tank_Img;
    private String tank_icon;
    private float tank_mainGunSize;
    private boolean is_premium;

    @Override
    public String toString() {
        return "AllTanks{" +
                "tank_id=" + tank_id +
                ", tank_name='" + tank_name + '\'' +
                ", tank_type='" + tank_type + '\'' +
                ", tank_Hp=" + tank_Hp +
                ", tank_MaxSpeed=" + tank_MaxSpeed +
                ", tank_turretRotateSpeed=" + tank_turretRotateSpeed +
                ", tank_reloadTime=" + tank_reloadTime +
                ", tank_frontArm=" + tank_frontArm +
                ", tank_sideArm=" + tank_sideArm +
                ", tank_topArm=" + tank_topArm +
                ", tank_backArm=" + tank_backArm +
                ", tank_shell01_Damage=" + tank_shell01_Damage +
                ", tank_shell01_penetrate=" + tank_shell01_penetrate +
                ", tank_shell02_Damage=" + tank_shell02_Damage +
                ", tank_shell02_penetrate=" + tank_shell02_penetrate +
                ", gun_shell_Damage=" + gun_shell_Damage +
                ", gun_shell_penetrate=" + gun_shell_penetrate +
                ", tank_needExp=" + tank_needExp +
                ", tank_Img='" + tank_Img + '\'' +
                ", tank_icon='" + tank_icon + '\'' +
                ", tank_mainGunSize=" + tank_mainGunSize +
                ", is_premium=" + is_premium +
                '}';
    }

    public Integer getTank_id() {
        return tank_id;
    }

    public void setTank_id(Integer tank_id) {
        this.tank_id = tank_id;
    }

    public String getTank_name() {
        return tank_name;
    }

    public void setTank_name(String tank_name) {
        this.tank_name = tank_name;
    }

    public String getTank_type() {
        return tank_type;
    }

    public void setTank_type(String tank_type) {
        this.tank_type = tank_type;
    }

    public Integer getTank_Hp() {
        return tank_Hp;
    }

    public void setTank_Hp(Integer tank_Hp) {
        this.tank_Hp = tank_Hp;
    }

    public Integer getTank_MaxSpeed() {
        return tank_MaxSpeed;
    }

    public void setTank_MaxSpeed(Integer tank_MaxSpeed) {
        this.tank_MaxSpeed = tank_MaxSpeed;
    }

    public Integer getTank_turretRotateSpeed() {
        return tank_turretRotateSpeed;
    }

    public void setTank_turretRotateSpeed(Integer tank_turretRotateSpeed) {
        this.tank_turretRotateSpeed = tank_turretRotateSpeed;
    }

    public float getTank_reloadTime() {
        return tank_reloadTime;
    }

    public void setTank_reloadTime(float tank_reloadTime) {
        this.tank_reloadTime = tank_reloadTime;
    }

    public Integer getTank_frontArm() {
        return tank_frontArm;
    }

    public void setTank_frontArm(Integer tank_frontArm) {
        this.tank_frontArm = tank_frontArm;
    }

    public Integer getTank_sideArm() {
        return tank_sideArm;
    }

    public void setTank_sideArm(Integer tank_sideArm) {
        this.tank_sideArm = tank_sideArm;
    }

    public Integer getTank_topArm() {
        return tank_topArm;
    }

    public void setTank_topArm(Integer tank_topArm) {
        this.tank_topArm = tank_topArm;
    }

    public Integer getTank_backArm() {
        return tank_backArm;
    }

    public void setTank_backArm(Integer tank_backArm) {
        this.tank_backArm = tank_backArm;
    }

    public Integer getTank_shell01_Damage() {
        return tank_shell01_Damage;
    }

    public void setTank_shell01_Damage(Integer tank_shell01_Damage) {
        this.tank_shell01_Damage = tank_shell01_Damage;
    }

    public Integer getTank_shell01_penetrate() {
        return tank_shell01_penetrate;
    }

    public void setTank_shell01_penetrate(Integer tank_shell01_penetrate) {
        this.tank_shell01_penetrate = tank_shell01_penetrate;
    }

    public Integer getTank_shell02_Damage() {
        return tank_shell02_Damage;
    }

    public void setTank_shell02_Damage(Integer tank_shell02_Damage) {
        this.tank_shell02_Damage = tank_shell02_Damage;
    }

    public Integer getTank_shell02_penetrate() {
        return tank_shell02_penetrate;
    }

    public void setTank_shell02_penetrate(Integer tank_shell02_penetrate) {
        this.tank_shell02_penetrate = tank_shell02_penetrate;
    }

    public Integer getGun_shell_Damage() {
        return gun_shell_Damage;
    }

    public void setGun_shell_Damage(Integer gun_shell_Damage) {
        this.gun_shell_Damage = gun_shell_Damage;
    }

    public Integer getGun_shell_penetrate() {
        return gun_shell_penetrate;
    }

    public void setGun_shell_penetrate(Integer gun_shell_penetrate) {
        this.gun_shell_penetrate = gun_shell_penetrate;
    }

    public Integer getTank_needExp() {
        return tank_needExp;
    }

    public void setTank_needExp(Integer tank_needExp) {
        this.tank_needExp = tank_needExp;
    }

    public String getTank_Img() {
        return tank_Img;
    }

    public void setTank_Img(String tank_Img) {
        this.tank_Img = tank_Img;
    }

    public String getTank_icon() {
        return tank_icon;
    }

    public void setTank_icon(String tank_icon) {
        this.tank_icon = tank_icon;
    }

    public float getTank_mainGunSize() {
        return tank_mainGunSize;
    }

    public void setTank_mainGunSize(float tank_mainGunSize) {
        this.tank_mainGunSize = tank_mainGunSize;
    }

    public boolean isIs_premium() {
        return is_premium;
    }

    public void setIs_premium(boolean is_premium) {
        this.is_premium = is_premium;
    }

    public AllTanks(Integer tank_id, String tank_name, String tank_type, String tank_Img, String tank_icon, boolean is_premium) {
        this.tank_id = tank_id;
        this.tank_name = tank_name;
        this.tank_type = tank_type;
        this.tank_Img = tank_Img;
        this.tank_icon = tank_icon;
        this.is_premium = is_premium;
    }

    public AllTanks(Integer tank_id, String tank_name, String tank_type, Integer tank_Hp, Integer tank_MaxSpeed, Integer tank_turretRotateSpeed, float tank_reloadTime, Integer tank_frontArm, Integer tank_sideArm, Integer tank_topArm, Integer tank_backArm, Integer tank_shell01_Damage, Integer tank_shell01_penetrate, Integer tank_shell02_Damage, Integer tank_shell02_penetrate, Integer gun_shell_Damage, Integer gun_shell_penetrate, Integer tank_needExp, String tank_Img, String tank_icon, float tank_mainGunSize, boolean is_premium) {
        this.tank_id = tank_id;
        this.tank_name = tank_name;
        this.tank_type = tank_type;
        this.tank_Hp = tank_Hp;
        this.tank_MaxSpeed = tank_MaxSpeed;
        this.tank_turretRotateSpeed = tank_turretRotateSpeed;
        this.tank_reloadTime = tank_reloadTime;
        this.tank_frontArm = tank_frontArm;
        this.tank_sideArm = tank_sideArm;
        this.tank_topArm = tank_topArm;
        this.tank_backArm = tank_backArm;
        this.tank_shell01_Damage = tank_shell01_Damage;
        this.tank_shell01_penetrate = tank_shell01_penetrate;
        this.tank_shell02_Damage = tank_shell02_Damage;
        this.tank_shell02_penetrate = tank_shell02_penetrate;
        this.gun_shell_Damage = gun_shell_Damage;
        this.gun_shell_penetrate = gun_shell_penetrate;
        this.tank_needExp = tank_needExp;
        this.tank_Img = tank_Img;
        this.tank_icon = tank_icon;
        this.tank_mainGunSize = tank_mainGunSize;
        this.is_premium = is_premium;
    }

    public AllTanks() {
    }
}
