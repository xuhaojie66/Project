package com.xufeng.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private String id;//订单id
    private String username;//用户名
    private Date time;//下单时间
    private int price;//订单价格

    public Order() {
    }

    public Order(String id, String username, Date time, int price) {
        this.id = id;
        this.username = username;
        this.time = time;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", price='" + price + '\'' +
                '}';
    }
}
