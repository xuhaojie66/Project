package com.xufeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo3")
public class demo3Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //实现页面的定时跳转功能
        response.getWriter().println("5秒后页面会跳转到百度页面");
        //meta值是Refresh,值是秒数和跳转的网站
        response.setHeader("Refresh","5;URL=https://www.baidu.com");
    }
}
