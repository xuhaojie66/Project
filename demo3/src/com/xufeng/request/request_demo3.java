package com.xufeng.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//获取所有请求头的信息
@WebServlet("/request_demo3")
public class request_demo3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //获取所有的请求头
        Enumeration<String> headernames=req.getHeaderNames();
        while(headernames.hasMoreElements()){
            String headername=headernames.nextElement();
            String headvalue=req.getHeader(headername);
            out.println(headername+"="+headvalue+"<br>");
        }
    }
}
