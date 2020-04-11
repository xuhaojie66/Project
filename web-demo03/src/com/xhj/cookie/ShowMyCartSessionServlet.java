package com.xhj.cookie;

import com.xhj.domain.Item;
import com.xhj.domain.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/session/showMyCart")
public class ShowMyCartSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println("<br><br><h1>我的购物车商品信息如下：</h1>");
        out.println("<table border='1' width='65%'>");
        out.println("<tr><th>条目编号</th><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>条目总金额</th></tr>");
        DecimalFormat sf = new DecimalFormat("###.00");
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if(shoppingCart!=null){
            for (Item i:shoppingCart.getItems()){
                out.println("<tr>");
                out.println("<td>"+i.getId()+"</td>");
                out.println("<td>"+i.getProduct().getName()+"</td>");
                out.println("<td>"+i.getProduct().getPrice()+"</td>");
                out.println("<td>"+i.getNumber()+"</td>");
                out.println("<td>"+sf.format(i.getSumMoney())+"</td>");
                out.println("</tr>");
            }
            out.println("<tr><td colspan='5' align='right'>"+sf.format(shoppingCart.getTotalSumMoney())+"</td></tr>");
        }
        out.println("</table>");
        out.println("<h3><a href='/cookie/shows'>继续购物</a>&nbsp;&nbsp;|<a href=''>结账</a></h3>");
    }
}
