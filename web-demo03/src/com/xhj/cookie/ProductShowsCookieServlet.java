package com.xhj.cookie;

import com.xhj.dao.ProductDao;
import com.xhj.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/cookie/shows")
public class ProductShowsCookieServlet extends HttpServlet {
    private ProductDao pdao=new ProductDao();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Product> all = pdao.findAll();
        out.println("<br><br><center>");
        out.println("<table border='1' width='75%'");
        out.println("<tr><th>商品编号</th><th>商品名称</th><th>商品价格</th><th>商品介绍</th><th>查看商品详情</th></tr>");
        for(Product p:all){
            out.println("<tr>");
            out.println("<td>"+p.getId()+"</td>");
            out.println("<td>"+p.getName()+"</td>");
            out.println("<td>"+p.getPrice()+"</td>");
            out.println("<td>"+p.getDesc()+"</td>");
            out.println("<td><a href='/cookie/findProduct?id="+p.getId()+"'>查看商品详情</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</center>");
    }
}

