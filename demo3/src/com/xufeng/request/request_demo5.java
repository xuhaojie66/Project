package com.xufeng.request;

import com.xufeng.dao.OrderDao;
import com.xufeng.domain.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/request_demo5")
public class request_demo5  extends HttpServlet {
    private OrderDao orderdao=new OrderDao();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        //调用dao层的方法获取所有订单
        List<Order> orders=orderdao.findAll();
        //将该集合设置到请求域中，然后请求转发到一个jsp页面，把数据展现给客户
        req.setAttribute("orders",orders);
        //请求转发到指定的jsp，并且把原始的请求和响应对象传递过去，这样才能获取到请求域中存储的数据
        req.getRequestDispatcher("/WEB-INF/order.jsp").forward(req,resp);
    }
}
