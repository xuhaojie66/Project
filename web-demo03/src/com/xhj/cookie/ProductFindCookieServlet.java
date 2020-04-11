package com.xhj.cookie;

import com.xhj.dao.ProductDao;
import com.xhj.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/findProduct")
public class ProductFindCookieServlet extends HttpServlet {
    private ProductDao pdao = new ProductDao();



    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        Product p = pdao.findById(id);
        if(p!=null){
            out.println("<img src='/images/"+p.getImagePath()+"'/><br>");
            out.println("商品编号："+p.getId()+"，商品名称："+p.getName()+"</br>");
            out.println("商品价格："+p.getPrice()+"，商品描述："+p.getDesc()+"</br>");

            Cookie cookie =null;//用来记录浏览过商品信息的cookie
            Cookie[] cookies = request.getCookies();
            for(int i=0;cookies!=null&&i<cookies.length;i++){
                if("products".equals(cookies[i].getName())){
                    cookie=cookies[i];
                    break;
                }
            }
            if(cookie==null){
                cookie= new Cookie("products",p.getId());
                cookie.setMaxAge(-1);//cookie保存在内存里
                cookie.setPath("/");
            }else{
                String[] array = cookie.getValue().split("-");
                if(array==null||array.length==1){
                    //查看之前浏览过的商品和本次的是否相同
                    if(!cookie.getValue().equals(p.getId())){
                        cookie.setValue(p.getId()+"-"+cookie.getValue());
                    }
                }else {
                    //若浏览过不止一个商品
                    boolean b=false;//用来标注该商品之前是否被浏览过
                    for(int i=0;i<array.length;i++){
                        if(array[i].equals(p.getId())){
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(p.getId()).append("-");
                            for(int j=0;j<array.length;j++){
                                if(j!=i){
                                    stringBuffer.append(array[j]).append("-");
                                }
                            }
                            //去掉多余的逗号
                            String line = stringBuffer.toString();
                            if(line.lastIndexOf("-")==line.length()-1){
                                line=line.substring(0,line.length()-1);
                            }
                            cookie.setValue(line);
                            b=true;
                            break;
                        }
                    }
                    if (!b){
                        if(array.length<5){
                            cookie.setValue(p.getId()+"-"+cookie.getValue());
                        }else{
                            cookie.setValue(p.getId()+"-"+cookie.getValue().substring(0,cookie.getValue().lastIndexOf("-")));
                        }
                    }
                }
            }
            response.addCookie(cookie);
        }
        out.println("<h3><a href='/cookie/shows'>回到商品主页</a></h3>");
    }
}
