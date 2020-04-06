package com.xhj.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie/login")
public class CookieUserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        if(userName.equals("admin")&&userpwd.equals("admin")){
            String flag = request.getParameter("flag");

            Cookie c1=null;
            Cookie c2=null;
            if(Boolean.valueOf(flag)){
                c1 = new Cookie("userName", userName);
                c2 = new Cookie("userpwd", userpwd);

            }else{
                c1 = new Cookie("userName", null);
                c2 = new Cookie("userpwd", null);
                c1.setMaxAge(1*30*24*60*60);
                c2.setMaxAge(1*30*24*60*60);
            }
            c1.setMaxAge(1*30*24*60*60);
            c2.setMaxAge(1*30*24*60*60);
            c1.setPath("/");
            c2.setPath("/");
            response.addCookie(c1);
            response.addCookie(c2);

            request.setAttribute("user",userName);
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }else{
            request.setAttribute("info","用户名或密码错误，请重新填写");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
