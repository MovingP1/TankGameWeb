package com.TG.pojo;

public class Videos {
    private Integer video_id;
    private String video_name;
    private String video_img;
    private String video_link;

    @Override
    public String toString() {
        return "Videos{" +
                "video_id=" + video_id +
                ", video_name='" + video_name + '\'' +
                ", video_img='" + video_img + '\'' +
                ", video_link='" + video_link + '\'' +
                '}';
    }

    public Videos(String video_name, String video_img, String video_link) {
        this.video_name = video_name;
        this.video_img = video_img;
        this.video_link = video_link;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_img() {
        return video_img;
    }

    public void setVideo_img(String video_img) {
        this.video_img = video_img;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public Videos(Integer video_id, String video_name, String video_img, String video_link) {
        this.video_id = video_id;
        this.video_name = video_name;
        this.video_img = video_img;
        this.video_link = video_link;
    }

    public Videos() {
    }
}
