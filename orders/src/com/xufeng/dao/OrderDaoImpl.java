package com.xufeng.dao;

import com.xufeng.pojo.Order;
import com.xufeng.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int add(String name,double price) {
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try{
            conn=BaseDao.getConn();
            String sql="insert into orders values(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            count=ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closedAll();
        }
        return count;
    }

    @Override
    public int deleteby_name(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try{
            conn=BaseDao.getConn();
            String sql="delete orders where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            count=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closedAll();
        }
        return count;
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public Order findby_name(String myname) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Order order=null;
        try {
            conn=BaseDao.getConn();
            String sql="select * from orders where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,myname);
            rs=ps.executeQuery();
            if (rs.next()){
                order=new Order();
                order.setId(rs.getInt(1));
                order.setNumber(rs.getString(2));
                order.setName(rs.getString(3));
                order.setPrice(rs.getDouble(4));
                order.setState(rs.getInt(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closedAll();
        }
        return order;
    }

    public static void main(String[] args) {
        OrderDaoImpl odi=new OrderDaoImpl();
        String name="小米10";

        System.out.println(odi.findby_name(name).toString());
    }
}
