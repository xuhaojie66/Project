package com.xufeng.login;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends GenericServlet {
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        //表单传来的数据封装在Reqest中
        //设置post提交方式的编码问题
        Request.setCharacterEncoding("utf-8");
        //获取表单传来的数据
        String username=Request.getParameter("username");
        String pwd=Request.getParameter("password");
        //设置响应的头信息（编码）
        Response.setContentType("text/html;charset=utf-8");
        //获取一个向客户端输出的流对象
        PrintWriter out=Response.getWriter();
        out.println("username: "+username);
        out.println("pwd: "+pwd);
    }
}
