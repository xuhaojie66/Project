package com.xufeng.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//模拟请求重定向，使用response对象实现
@WebServlet("/demo1")
public class demo1Servelt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的状态码
        response.setStatus(302);
        //设置响应头，名称为location,其值为另一个资源的访问路径
        response.setHeader("location","https://www.baidu.com");
        //结论：可以通过对response的设置（把status状态码设置为302，同时使用setHeader()方法设置meta的名称为location的头信息）
        //其作用和后面要讲的请求重定向类似
    }
}
