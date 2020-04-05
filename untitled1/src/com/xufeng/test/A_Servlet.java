package com.xufeng.test;

import javax.servlet.*;
import java.io.IOException;

public class A_Servlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Config: "+servletConfig.getInitParameter("username"));
        System.out.println("Context: "+servletConfig.getServletContext().getInitParameter("username"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
