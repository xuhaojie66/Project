<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Target</h1>
    <%
        String name=(String) request.getAttribute("name");

    %>
    <%=name%>
</body>
</html>
