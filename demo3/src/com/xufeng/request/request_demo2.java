package com.xufeng.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

//获取表单中的数据
@WebServlet("/request_demo2")
public class request_demo2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
        //获取表单数据
        String name=req.getParameter("name");
        out.println("name="+name+"<br>");
        String uesrid=req.getParameter("userid");
        out.println("userid="+uesrid+"<br>");
        String[] hobbies=req.getParameterValues("hobby");
        out.println("hobbis="+ Arrays.toString(hobbies)+"<br>");
        //获取表单中的参数
        Enumeration<String> keywords=req.getParameterNames();
        while(keywords.hasMoreElements()){
            String keyword=keywords.nextElement();
            String[] value=req.getParameterValues(keyword);
            String value0=array_tostring(value);
            out.println(keyword+"="+value0+"<br>");
        }
        //使用getParameterMap获取表单中的所有数据
        Map<String,String[]> map=req.getParameterMap();
        Set<String> keys=map.keySet();
        for(String key:keys){
            String value=array_tostring(map.get(key));
            out.println(key+"="+value+"<br>");
        }
    }
    private String array_tostring(String[] array){
        StringBuilder sb=new StringBuilder();
        int len=array.length;
        int i=1;
        while(i<=len){
            sb.append(array[i-1]);
            sb.append(",");
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
