package com.xhj.cookie;

import com.xhj.dao.ProductDao;
import com.xhj.domain.Product;
import com.xhj.domain.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session/addCart")
public class AddProductToCart extends HttpServlet {
    private ProductDao productDao= new ProductDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product p = productDao.findById(pid);
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if(shoppingCart == null){
            shoppingCart=new ShoppingCart();
        }
        shoppingCart.addCart(p);

        session.setAttribute("cart",shoppingCart);

        response.sendRedirect(request.getContextPath()+"/cookie/shows");
    }
}
