<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/17
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test1</title>
</head>
<body>
    <h1>Test1</h1>
    <%
        String idStr=request.getParameter("id");
        Integer id=Integer.parseInt(idStr);
        id++;
        //将数据存入到request中
        request.setAttribute("number",id);
        //将请求转发给test2.jsp
        request.getRequestDispatcher("test2.jsp").forward(request,response);
        String[] names=request.getParameterValues("name");
    %>
    <%=Arrays.toString(names)%>
</body>
</html>
