package com.TG.pojo;

public class Store {
    private Integer item_id;
    private String item_name;
    private Integer item_price;
    private String item_img;
    private String item_detail;
    private String item_type;
    private Integer gold_price;
    private Integer item_attribute;

    @Override
    public String toString() {
        return "Store{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", item_img='" + item_img + '\'' +
                ", item_detail='" + item_detail + '\'' +
                ", item_type='" + item_type + '\'' +
                ", gold_price=" + gold_price +
                ", item_attribute=" + item_attribute +
                '}';
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public String getItem_detail() {
        return item_detail;
    }

    public void setItem_detail(String item_detail) {
        this.item_detail = item_detail;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Integer getGold_price() {
        return gold_price;
    }

    public void setGold_price(Integer gold_price) {
        this.gold_price = gold_price;
    }

    public Integer getItem_attribute() {
        return item_attribute;
    }

    public void setItem_attribute(Integer item_attribute) {
        this.item_attribute = item_attribute;
    }

    public Store(Integer item_id, String item_name, Integer item_price, String item_img, String item_detail, String item_type, Integer gold_price, Integer item_attribute) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_img = item_img;
        this.item_detail = item_detail;
        this.item_type = item_type;
        this.gold_price = gold_price;
        this.item_attribute = item_attribute;
    }
    public Store(Integer item_id, String item_name, Integer item_price, String item_img, String item_detail, String item_type) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_img = item_img;
        this.item_detail = item_detail;
        this.item_type = item_type;
    }

    public Store() {
    }
}
