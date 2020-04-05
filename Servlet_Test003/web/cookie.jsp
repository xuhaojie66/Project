<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //创建cookie
        Cookie cookie=new Cookie("name","tom");
        response.addCookie(cookie);
        //读取cookie
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie1:cookies){
            out.write(cookie1.getName()+":"+cookie1.getValue()+"<br/>");
        }
    %>
</body>
</html>
