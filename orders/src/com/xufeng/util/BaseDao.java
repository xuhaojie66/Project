package com.xufeng.util;

import java.sql.*;

public class BaseDao {
    //将数据库链接需要使用的驱动地址、链接地址、用户名、密码作为静态常量使用
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
    private static final String UNAME="root";
    private static final String PWD="123";
    //开关（链接对象）
    protected static Connection conn=null;
    //获取数据（预编译对象、存储结果对象）
    protected static PreparedStatement ps=null;
    protected static ResultSet rs=null;
    //加载驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取数据库
    public static Connection getConn(){
        try {
            conn= DriverManager.getConnection(URL,UNAME,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closedAll() {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //查询
    public static ResultSet executQery(String sql,Object[] obj){
        getConn();
        try {
            ps=conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    ps.setObject(i+1,obj[i]);
                }
            }
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int executeUpdate(String sql,Object[] obj){
        int count=0;
        getConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(obj!=null){
            for(int i=0;i<obj.length;i++){
                try {
                    ps.setObject(i+1,obj[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                count=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closedAll();
            }
        }
        return count;
    }
}
