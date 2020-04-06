package com.xhj.dao;

import com.xhj.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static List<Product> list=new ArrayList<>();

    static {
        list.add(new Product("10001" , "springMVC","1.png" , 106.9,"学习Java的经典书籍! "));
        list.add(new Product("10002" , "springboot","2.png" , 107.9,"学习Java的经典书籍! "));
        list.add(new Product("10003" , "Java编程思想","3.png" , 75,"学习Java的经典书籍! "));
        list.add(new Product("10004" , "redis实战","4.png" , 57.8,"学习Java的经典书籍! "));
        list.add(new Product("10005" , "spring实战","5.png" , 73.7,"学习Java的经典书籍! "));
        list.add(new Product("10006" , "mybatis内幕","6.png" , 62.3,"学习Java的经典书籍! "));
        list.add(new Product("10007" , "高性能mysql","7.png" , 90.3,"学习Java的经典书籍! "));
        list.add(new Product("10008" , "spring cloud","8.png" , 70.3,"学习Java的经典书籍! "));
    }
    public List<Product> findAll(){
        return list;
    }
    public Product findById(String id){
        Product p=null;
        for (Product product:list){
            if(product.getId().equals(id)){
                p=product;
                break;
            }
        }
        return p;
    }
}
