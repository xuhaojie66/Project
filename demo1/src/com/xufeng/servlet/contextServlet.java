package com.xufeng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
/*
ServletContext作为域对象的应用：
使用servletconfig用来统计当前页面或资源被访问的次数
    setAttribute("name","value")
    getAttribute("name")，返回值
    getAttributeNames() 获取所有值
    removeAttribute("name") 销毁

 */
@WebServlet("/c")
public class contextServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应头文件
        response.setContentType("html/text,charset=utf-8");
        //获取向客户端输出的流对象
        PrintWriter out=response.getWriter();
        //获取上下文对象
        ServletContext context=this.getServletContext();
        context.setAttribute("name","xu");
        context.setAttribute("year","20");
        //先从上下文域中获取值（用来统计当前servlet被访问的次数）
        Integer num=(Integer) context.getAttribute("count");
        //判断num是否有值或为空，空表示该servlet是第一次被访问
        //避免空指针异常，判空需要放在前面
        if(num==null||num==0){
            context.setAttribute("count",Integer.valueOf(1));
        }else {
            context.setAttribute("count", ++num);
        }
        int count=(Integer) context.getAttribute("count");
        out.println("count="+count);
        Enumeration<String> arrs=context.getAttributeNames();
        while(arrs.hasMoreElements()){
            String name=arrs.nextElement();
            Object value=context.getAttribute(name);
            out.println(name+"="+value);
        }
    }
}