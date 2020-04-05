package com.xufeng.user;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Enumeration;

public class config_contextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        PrintWriter out=response.getWriter();
        ServletContext context=this.getServletContext();
        ServletConfig config=this.getServletConfig();
        Enumeration<String> context_params=context.getInitParameterNames();
        Enumeration<String> config_params=config.getInitParameterNames();
        while(context_params.hasMoreElements()){
            String param_name=context_params.nextElement();
            String param_value=context.getInitParameter(param_name);
            out.println("context:"+param_name+":"+param_value);
        }
        while(config_params.hasMoreElements()){
            String param_name=config_params.nextElement();
            String param_value=config.getInitParameter(param_name);
            out.println("config:"+param_name+":"+param_value);
        }
    }
}
