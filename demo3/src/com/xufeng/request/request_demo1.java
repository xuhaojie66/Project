package com.xufeng.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/request_demo1")
public class request_demo1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //getMethod获取请求的方式
        String method=req.getMethod();
        out.println("getMethod()方法获取请求的方式："+method+"<br>");
        //getRequestURI()获取请求行中资源名称部分，即位于URL的主机和端口之后参数之前的部分
        String uri=req.getRequestURI();
        out.println("getRequestURI()="+uri+"<br>");
        //getRequestURL()方法返回值为StringBuffer类型，便于修改，返回请求的所有URL，包括协议、服务器名、端口、资源路径，但不包括参数
        String url=req.getRequestURL().toString();
        out.println("getRequestURL()="+url+"<br>");
        //获取请求行中的参数部分
        String queryString=req.getQueryString();
        out.println("请求行中的参数="+queryString+"<br>");
        //获取客户端IP
        String clieniIp=req.getRemoteUser();
        out.println("客户端IP="+clieniIp+"<br>");
        //获取客户端主机名称
        String clientHost=req.getRemoteHost();
        out.println("客户端主机名称="+clientHost+"<br>");
        //动态获取项目名称
        String contextPath=req.getContextPath();
        out.println("项目名称="+contextPath+"<br>");
        //获取servlet的名称或映射的路径
        String servletPath=req.getServletPath();
        out.println("servlet的名称="+servletPath+"<br>");

    }
}
