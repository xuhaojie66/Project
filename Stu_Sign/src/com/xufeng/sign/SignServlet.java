package com.xufeng.sign;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


//实现学生签到功能，并将签到记录保存到文件中
/*
ServletConfig:可以用来获取为该servlet配置的初始化参数信息，在web.xml中可以通过使用
init-param标签来给该Servlet配置初始化参数
 */
/*
注解功能：
urlPatterns访问路径
initParams配置初始化参数
loadOnStartup默认为0或负值，在用户第一次请求时servelet被创建，赋值为正值，服务器启动时被加载
 */
//@WebServlet(urlPatterns = {"/sign"},
//            initParams = {@WebInitParam(name="path",value = "E:\\\\login.txt")},
//            loadOnStartup = 1
//)
public class SignServlet implements Servlet {
    PrintWriter fout;
    String filePath;
    //判断是否代签——ip地址是否出现在文件中过
    public int judge(String loginTime,String ip,String id){
        String[] strs=new String[10];
        //获取用户ip地址
        //1.按行读取文件
        File file=new File(filePath);
        ArrayList<String> arr=new ArrayList<>();
        String str;
        InputStreamReader isr= null;
        BufferedReader br=null;
        try {
            isr = new InputStreamReader(new FileInputStream(file));
            br=new BufferedReader(isr);
            while((str=br.readLine())!=null){
                arr.add(str);
            }
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.每行信息按空格分割存入数组中
        for(int i=0;i<arr.size();i++){
            str=arr.get(i);
            strs=str.split(" ");
        }
        System.out.println(strs[5]+" "+ip+" "+strs[7]+" "+loginTime.substring(0,10));
        System.out.println(strs[1]+" "+id);
        //判断签到日期和ip地址是否同时一致
        if(strs[1]!=null&&strs!=null&&strs[1].equals(id)){
            return 1;
        }
        else if(strs[5]!=null&&strs[7]!=null&&strs[5].equals(ip)&&strs[7].equals(loginTime.substring(0,10))){
            return 2;
        }
        return 0;
    }

    @Override

    public void init(ServletConfig servletConfig) throws ServletException {
        //为了提高文件的执行效率，把文件打开操作放在这里
        //默认是第一次访问该Servlet类时被执行
        filePath=servletConfig.getInitParameter("path");
        File file=new File(filePath);
        try {
            fout=new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取用户的请求
        String id=request.getParameter("stuId");
        String name=request.getParameter("stuName");
        //获取用户的IP地址
        String ip=request.getRemoteAddr();
        //获取用户的签到时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime=sdf.format(new Date());
        PrintWriter out = response.getWriter();
        if(id.length()!=10){
            out.println("学号不符合要求");
        }
        else if(judge(loginTime,ip,id)==0) {
        /*
            判断某段代码是否会有线程安全问题的判断条件：
            1.两个或两个以上的线程：对于servlet，每个用户访问都会开启一个新的线程
              （servive是基于多线程的方法）
            2.操作的是不是同一份资源：所有用户操作的都是同一个PrintWriter流对象fout
              采用同步的方式来解决问题
         */
            //使用fout把用户的信息记录到文件中

            if (fout != null) {
                synchronized (this) {
                    fout.println("学号是: " + id + " 姓名是: " + name + " IP是: " + ip + " 的学生在 " + loginTime + " 签到成功。");
                    fout.flush();
                }
            }
            //输出到页面中

            out.println(name + "签到成功！");
            //out.println("path="+filePath);
        }
        else if(judge(loginTime,ip,id)==1){
            out.println("请勿重复签到！");
        }
        else if(judge(loginTime,ip,id)==2){

            out.println("请勿代签！");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //在这个里面处理文件的关闭操作
        if(fout!=null){
            fout.close();
        }
    }
}
