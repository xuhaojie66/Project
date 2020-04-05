<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test2</title>
</head>
<body>
<h1>Test2</h1>
<%
    Integer number=(Integer) request.getAttribute("number");
%>
<%=number%>
</body>
</html>
