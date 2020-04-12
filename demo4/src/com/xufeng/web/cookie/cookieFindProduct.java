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

@WebServlet("/findProduct")
public class cookieFindProduct extends HttpServlet {
    private Product product=null;
    private ProductDao pd=new ProductDao();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        String id=req.getParameter("id");
        product=pd.findById(id);
        if(product!=null){
            out.println("<img src='/'"+product.getImagePath()+">");
            out.println(product.getPrice()+"<br>");
            out.println(product.getDesc()+"<br>");
        }
    }
}
