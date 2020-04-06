package com.xufeng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/resource")
public class contextResourceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取响应头文件
        response.setContentType("text/html;charset=utf-8");
        //获取向客户端输出的流对象
        PrintWriter out=response.getWriter();
        //获取上下文对象
        ServletContext context=this.getServletContext();
        //获取文件夹路径
        String parentPath=context.getRealPath("/downloads");
        out.println(parentPath+"<br><hr>");
        //把字符串封装成一个文件对象
        File file=new File(parentPath);
        //因为该文件是一个文件夹，我们需要遍历该文件夹中的所有文件，并存入文件数组中
        File[] files=file.listFiles();
        //遍历
        out.println("<br>当前可下载的资源有：<br>");
        for (File f:files){
            System.out.println("!");
            String name=f.getName();
            out.println(name+"<br>");
        }
    }
}
