package com.xufeng.dao;

import com.xufeng.domain.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    public List<Order> findAll(){
        List<Order> orders=new ArrayList<Order>();
        for(int i=0;i<20;i++){
            orders.add(new Order("1000"+i,"User-"+i,new Date(),(int)(Math.random()*1000)+1));
        }
        return orders;
    }

}
