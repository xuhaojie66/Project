package com.xufeng.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login_C")
public class login_Cookie extends HttpServlet {
    private String myusername="admin";
    private String mypassword="123123";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(username.equals(myusername)&&password.equals(mypassword)){
            Cookie cookie=new Cookie("name",username);
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
            resp.sendRedirect("welcom.jsp");
        }
        else{
            resp.sendRedirect("login.jsp");
        }
    }
}
