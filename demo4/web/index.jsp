<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/lastTime">cookie会话技术实例-1：获取最后一次访问系统的时间</a>
  <br>
  <hr>
  <a>cookie会话技术实例-2：自动提取登陆的用户名和密码</a>
  <%
    String info="";
    String username="";
    String password="";
    if (request.getAttribute("info")!=null)
      info=(String)request.getAttribute("info");
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      for(Cookie cookie:cookies){
        if(cookie.getName().equals("username")){
          username=cookie.getValue();
        }
        if(cookie.getName().equals("password")){
          password=cookie.getValue();
        }
      }
      System.out.println(username+password);
    }

  %>
  <form action="/login" method="post">
    <a><%=info%></a>
  <table width="50%" >
    <tr><td>用户名</td><td><input type="text" name="username" value="<%=username%>"></td></tr>
    <tr><td>密码</td><td><input type="password" name="password" value="<%=password%>"></td></tr>
    <tr><td align="left" colspan="2"><input type="checkbox" name="flag" value="true">记住用户名和密码</td></tr>
    <tr><td><input type="submit" value="登陆"></td><td><input type="reset" value="重置"></td></tr>
  </table>
  </form>
  <br><br>
  <hr>
  <a href="/showsProduct">查看网上商城</a>
  </body>
</html>
