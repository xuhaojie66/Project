<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <%
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("name")){
                out.write("欢迎回来"+cookie.getValue());
            }
        }
    %>
    <a href="login">退出</a>


</body>
</html>
