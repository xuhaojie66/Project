package com.xufeng.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//登陆注册记住用户名和密码
@WebServlet("/login")
public class cookieLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(username.equals("xf")&&password.equals("xufeng0606")){
            if(Boolean.valueOf(req.getParameter("flag"))){
                Cookie c1=new Cookie("username",username);
                Cookie c2=new Cookie("password",password);
                c1.setMaxAge(7*30*24*60*60);
                c2.setMaxAge(7*30*24*60*60);
                c1.setPath("/");
                c2.setPath("/");
                resp.addCookie(c1);
                resp.addCookie(c2);
            }
            req.setAttribute("info",username+"登陆成功");
            req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req,resp);
        }else{
            req.setAttribute("info","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
