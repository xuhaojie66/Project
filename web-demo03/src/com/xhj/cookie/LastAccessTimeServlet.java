package com.xhj.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie/lastTime")
public class LastAccessTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie lastTime = null;
        Cookie[] cookies = request.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            String name = cookies[i].getName();
            if("lastTime".equals(name)){
                lastTime=cookies[i];
                break;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        if(lastTime==null){
            out.println("欢迎光临，您是第一次访问我们网站，欢迎以后常来往！");
            lastTime= new Cookie("lastTime",sdf.format(new Date()));
        }else{
            out.println("用户您好，您的上一次访问时间为["+lastTime.getValue()+"],感谢你的再次访问！");
            lastTime= new Cookie("lastTime",sdf.format(new Date()));
        }
        lastTime.setMaxAge(1*30*24*60*60);
        lastTime.setPath("/");
        response.addCookie(lastTime);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
