<%--
  Created by IntelliJ IDEA.
  User: Kyrie
  Date: 2020/4/5
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>cookie 测试场景-登录测试</h2>
<%
    String info ="";
    if(request.getAttribute("info")!=null){
        info= (String) request.getAttribute("info");
    }
    String userName = "";
    String userpwd ="";
    Cookie[] cookies = request.getCookies();
    for(int i=0;i<cookies.length;i++){
        if("userName".equals(cookies[i].getName())){
            userName=cookies[i].getValue();
        }
        if("userpwd".equals(cookies[i].getName())){
            userpwd=cookies[i].getValue();
        }
    }
%>
<h3><font color="red"><%=info %></font></h3>
<form action="/cookie/login" method="post">
    <table border="1" width="55%">
        <tr><td>用户名：</td><td><input type="text" name="username" value="<%=userName %>"></td></tr>
        <tr><td>密  码：</td><td><input type="password" name="userpwd" value="<%=userpwd %>"></td></tr>
        <tr><td>记住用户名和密码</td><td><input type="checkbox" name="flag" value="true">记住我</td></tr>
        <tr><td align="center" colspan="2"><input type="submit" value="登录"></td></tr>
    </table>
</form>
</body>
</html>
