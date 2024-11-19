package com.TG.pojo;

import java.util.Date;

public class News {
    private Integer news_id;
    private Date create_date;
    private String news_type;
    private String news_title;
    private String news_shortcut;
    private String news_imges;
    private String news_detail;

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", create_date=" + create_date +
                ", news_type='" + news_type + '\'' +
                ", news_title='" + news_title + '\'' +
                ", news_shortcut='" + news_shortcut + '\'' +
                ", news_imges='" + news_imges + '\'' +
                ", news_detail='" + news_detail + '\'' +
                '}';
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_shortcut() {
        return news_shortcut;
    }

    public void setNews_shortcut(String news_shortcut) {
        this.news_shortcut = news_shortcut;
    }

    public String getNews_imges() {
        return news_imges;
    }

    public void setNews_imges(String news_imges) {
        this.news_imges = news_imges;
    }

    public String getNews_detail() {
        return news_detail;
    }

    public void setNews_detail(String news_detail) {
        this.news_detail = news_detail;
    }

    public News(Date create_date, String news_type, String news_title, String news_shortcut, String news_imges, String news_detail) {
        this.create_date = create_date;
        this.news_type = news_type;
        this.news_title = news_title;
        this.news_shortcut = news_shortcut;
        this.news_imges = news_imges;
        this.news_detail = news_detail;
    }

    public News(Integer news_id, Date create_date, String news_type, String news_title, String news_shortcut, String news_imges, String news_detail) {
        this.news_id = news_id;
        this.create_date = create_date;
        this.news_type = news_type;
        this.news_title = news_title;
        this.news_shortcut = news_shortcut;
        this.news_imges = news_imges;
        this.news_detail = news_detail;
    }

    public News() {
    }
}
