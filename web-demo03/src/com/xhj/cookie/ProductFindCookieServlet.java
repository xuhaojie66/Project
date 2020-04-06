package com.xhj.cookie;

import com.xhj.dao.ProductDao;
import com.xhj.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/findProduct")
public class ProductFindCookieServlet extends HttpServlet {
    private ProductDao pdao = new ProductDao();

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        Product p = pdao.findById(id);
        if(p!=null){
            out.println("<img src='/images/"+p.getImagePath()+"'/><br>");
            out.println("商品编号："+p.getId()+"，商品名称："+p.getName()+"</br>");
            out.println("商品价格："+p.getPrice()+"，商品描述："+p.getDesc()+"</br>");

        }
        out.println("<h3><a href='/cookie/shows'>回到商品主页</a></h3>");
    }
}
