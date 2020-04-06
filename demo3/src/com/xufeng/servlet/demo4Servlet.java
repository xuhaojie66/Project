package com.xufeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//实现页面的实时刷新
@WebServlet("/demo4")
public class demo4Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Refresh","1");
        //获取当前系统时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String time=sdf.format(new Date());
        response.getWriter().println("<h1>"+"当前系统时间为："+time+"</h1>");
    }
}
