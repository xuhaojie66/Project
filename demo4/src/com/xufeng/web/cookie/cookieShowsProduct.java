package com.xufeng.web.cookie;

import com.xufeng.web.dao.ProductDao;
import com.xufeng.web.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/showsProduct")
public class cookieShowsProduct extends HttpServlet {
    private ProductDao pd=new ProductDao();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //1.查询出所有商品并在页面上显示
        List<Product> products=pd.findAll();
        //商品显示完全采用servlet，强行拼凑出html标签
        out.println("<table align='center' border='1'>");
        out.println("<tr><th>商品id</th><th>商品名称</th><th>商品价格</th><th>商品描述</th><th>查看商品详情</th></tr>");
        for(Product product:products){
            out.println("<tr>");
            out.println("<td>"+product.getId()+"</td>");
            out.println("<td>"+product.getName()+"</td>");
            out.println("<td>"+product.getPrice()+"</td>");
            out.println("<td>"+product.getDesc()+"</td>");
            out.println("<td><a href='/findProduct?id="+product.getId()+"'>查看详情</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
