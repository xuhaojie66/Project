package com.xhj.servlet;

import com.xhj.pojo.Student;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet类
 */
public class SignServlet implements Servlet {
    private PrintWriter pout;
    private ServletConfig config;
    /**
     * 初始化
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=servletConfig;
        String filepath = servletConfig.getInitParameter("path");
        File file = new File(filepath);
        try {
            pout= new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String stuId = request.getParameter("stuId");
        String name = request.getParameter("name");
        String id = request.getRemoteAddr();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        //将前端传过来的数据封装成对象
        Student student = new Student();
        student.setStuId(stuId);
        student.setName(name);
        student.setId(id);
        student.setCreateTime(date);
        //调用方法读取文件，判断是否有重复签到和代签情况
        Map<Integer, String> map = this.selectFile(student);
        if(map.get(-1)!=null||map.get(-2)!=null){
            PrintWriter out = response.getWriter();
            out.println(map);
        }else {
            //用线程来确保每个学生签到完成
            if (pout != null) {
                synchronized (this) {
                    pout.println("学号是: " + stuId + " 姓名是: " + name + " 地址是: " + id + " 时间为: " + date);
                    pout.flush();
                }
            }
            //签到完成输出签到成功
            PrintWriter out = response.getWriter();
            out.println(name + "签到成功！");
        }

    }
    //  查询文件内容方法，判断是否有代签和重复签到情况
    public Map<Integer,String> selectFile(Student student) throws IOException {
        Map<Integer,String> map = new HashMap<>();
        String filepath = this.config.getInitParameter("path");
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str = null;
        //一次读入一行数据，并封装成student对象，与输入数据作比较
        while ((str=reader.readLine())!=null){
            String[] strings = str.split(" ");
            Student student1 = new Student();
            student1.setStuId(strings[1]);
            student1.setId(strings[5]);
            if(student.getStuId().equals(student1.getStuId())){
                map.put(-1,"重复签到");
                break;
            }else if(student.getId().equals(student1.getId())){
                map.put(-2,"代替签到");
                break;
            }
        }
        return map;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //关闭文件输入流
    @Override
    public void destroy() {
        if(pout!=null){
            pout.close();
        }
    }
}
