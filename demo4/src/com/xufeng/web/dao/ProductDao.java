package com.xufeng.web.dao;

import com.xufeng.web.domain.Product;

import java.util.ArrayList;
import java.util.*;

//dao层实现对商品的查询
public class ProductDao {
    private static List<Product> products=new ArrayList<Product>();
    static {
        //在静态代码块中实现对list集合的初始化
        products.add(new Product("10001","Java编程思想","1.png",89.1,"学习Java的经典书籍！"));
        products.add(new Product("10002","JavaWeb技术开发","2.png",54,"学习JavaWeb的经典书籍！"));
        products.add(new Product("10003","SSM框架整合开发","3.png",65,"学习SSM整合的经典书籍！"));
        products.add(new Product("10004","SpringBoot企业级开发","4.png",89.1,"学习SpringBoot的经典书籍！"));
        products.add(new Product("10005","Python从入门到精通","5.png",78,"学习Python的经典书籍！"));
        products.add(new Product("10006","Oracle数据库","6.png",85.3,"学习Oracle的经典书籍！"));
        products.add(new Product("10007","MySQL数据库","7.png",64,"学习MySQL的经典书籍！"));
        products.add(new Product("10008","Web前端","8.png",94.8,"学习Web的经典书籍！"));
    }
    public List<Product> findAll(){
        return products;
    }
    public Product findById(String id){
        Product p=null;
        if(products!=null){
            for(Product product:products){
                if(product.getId().equals(id)){
                    p=product;
                    break;
                }
            }
        }
        return p;
    }


}
