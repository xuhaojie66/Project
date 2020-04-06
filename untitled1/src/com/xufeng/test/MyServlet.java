package com.xufeng.test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet implements Servlet {
    //无参构造器只调用一次，创建对象
    public  MyServlet() {

    }
    @Override
    //init()只调用一次
    //SerletConfig接口是用来描述servlet基本信息的
    public void init(ServletConfig servletConfig) throws ServletException {
        String name=servletConfig.getServletName();//name=myservlet
        Enumeration<String> enumeration= servletConfig.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String element= enumeration.nextElement();
            System.out.println(element+": "+servletConfig.getInitParameter(element));//getInitParameter()获取init参数的值
        }
        ServletContext servletContext=servletConfig.getServletContext();
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getServerInfo());//获取tomcat版本
        System.out.println(servletContext.getInitParameter(""));//取整个应用的初始化参数
        System.out.println("Config: "+servletConfig.getInitParameter("username"));
        System.out.println("Context: "+servletConfig.getServletContext().getInitParameter("username"));

    }
    /*
    ServletConfig和ServletContext区别：
    前者作用于某一个servlet实例，每个servlet都有对应的ServletConfig
    后者作用于整个的web应用，一个Web应用对应一个ServletContext，多个servlet实例对应一个ServletContext
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //调用n次，执行业务方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String id=servletRequest.getParameter("id");
        System.out.println("我是Servlet,我已接收客户端发来的请求,id="+id);
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.getWriter().write("客户端你好，我已接收到你的请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    //调用一次，卸载对象
    @Override
    public void destroy() {

    }
}
