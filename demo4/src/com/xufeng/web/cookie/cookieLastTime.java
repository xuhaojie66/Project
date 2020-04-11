package com.xufeng.web.cookie;

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

/*
通过cookie获取最后一次访问系统的时间
 */
@WebServlet("/lastTime")
public class cookieLastTime extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        //首先创建一个cookie对象，用来保存所要获取的记录时间的一个cookie对象
        Cookie lastTimeCookie=null;
        //获取当前请求下的所有cookie对象
        Cookie[] cookies=req.getCookies();
        //遍历比对cookies数组
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            String cookieName=cookies[i].getName();//获取cookie对象的name
            if(cookieName.equals("lastTime")){
                //表明当前请求中已有名为lastTime的cookie，说明用户不是第一次访问系统
                //将此cookie对象赋给之前声明的lastTimeCookie
                lastTimeCookie=cookies[i];
                break;
            }
        }
        //获取当前系统时间作为cookie的值，注意cookie的值不能有非法字符“空格”
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
        if(lastTimeCookie==null){//是第一次访问
            out.println("您好，您是第一次在此浏览器访问");
            lastTimeCookie=new Cookie("lastTime",sdf.format(new Date()));
        }else{//不是第一次访问
            //获取此cookie的值
            String cookieValue=lastTimeCookie.getValue();
            out.println("您上次在此浏览器访问的时间是"+cookieValue);
            //更新cookie的值
            lastTimeCookie.setValue(sdf.format(new Date()));
        }
        //设置cookie的最大保存时间，单位为秒
        lastTimeCookie.setMaxAge(1*30*24*60*60);
        //cookie默认为当前路径可见，将其设置为对项目中所有资源均可见
        lastTimeCookie.setPath("/");
        //最后一步，将cookie对象添加到响应信息中，连同响应信息一起发给客户端，因为cookie是保存在客户端的会话技术
        resp.addCookie(lastTimeCookie);
    }
}
