package com.xufeng.dao;

import com.xufeng.pojo.Order;

public interface OrderDao {
    public int add(String name,double price);
    public int deleteby_name(String name);
    public int update(Order order);
    public Order findby_name(String name);
}
