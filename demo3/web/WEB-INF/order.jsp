<%@ page import="java.util.List" %>
<%@ page import="com.xufeng.domain.Order" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/10
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
</head>
<body>
    <!--实现数据的显示-->
    <table border="1" align="center" width="75%">
        <tr><th>订单编号</th><th>用户名称</th><th>下单时间</th><th>订单价格</th></tr>
        <%
            List<Order> orders=(List<Order>) request.getAttribute("orders");
            if(orders!=null){
                for(Order order:orders){
                    out.println("<tr>");
                    out.println("<td>"+order.getId()+"</td>");
                    out.println("<td>"+order.getUsername()+"</td>");
                    out.println("<td>"+order.getTime()+"</td>");
                    out.println("<td>"+order.getPrice()+"</td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
</body>
</html>
