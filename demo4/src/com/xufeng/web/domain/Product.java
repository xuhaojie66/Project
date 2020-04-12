package com.xufeng.web.domain;

public class Product {
    private String id;
    private String name;
    private String imagePath;
    private double price;
    private String desc;//商品的描述

    public Product() {
    }

    public Product(String id, String name, String imagePath, double price, String desc) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
