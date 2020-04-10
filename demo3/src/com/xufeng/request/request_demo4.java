package com.xufeng.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//防盗链技术和重定向
@WebServlet("/request_demo4")
public class request_demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //获取referer的值
        String referer=req.getHeader("referer");
        //获取访问的地址
        String site="http://"+req.getServerName();
        System.out.println(site);
        System.out.println(referer);
        //判断referer是否为空，是否以site开头
        if(referer!=null&&referer.startsWith(site)){//是从本站访问的
            out.println("可供下载......");
        }
        else {//不是从本站访问的，通过重定向跳转到本站的资源
            resp.sendRedirect(req.getContextPath()+"/download.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
