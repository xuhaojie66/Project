package com.xufeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
@WebServlet("/demo5")
//实现文件下载操作，文件名是中文时，需要针对不同的浏览器进行相关设置
public class demo5Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义要下载的文件名称
        String filename="宠物用例说明文档.docx";
        //设置下载的头信息参数，也就是告诉浏览器打开一个下载的窗口
        //对于不同的浏览器其User-Agent中出现的关键字是不同的
        String[] keywords={"MISE","Trident","Edge"};
        String userAgent=request.getHeader("User-Agent");
        boolean targetBrowser=true;
        for(String keyword:keywords){
            if(userAgent.contains(keyword)){
                filename= URLEncoder.encode(filename,"UTF-8");
                targetBrowser=false;
                break;
            }
        }
         if(targetBrowser){//火狐浏览器
            filename=new String(filename.getBytes("UTF-8"),"ISO8859-1");
        }
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        //获取输出流对象
        OutputStream out=response.getOutputStream();
        //获取文件的绝对路径
        String realpath=this.getServletContext().getRealPath("/down");
        System.out.println(realpath);
        //获取该路径的输入流对象
        File file=new File(realpath,"宠物用例说明文档.docx");
        if(file.exists()){
            FileInputStream fis=new FileInputStream(file);
            int cnt=-1;
            byte[] buff=new byte[1024];
            //实现文件的拷贝功能
            while((cnt=fis.read(buff))>0){
                out.write(buff,0,cnt);
            }
            fis.close();
        }
        out.close();

    }
}
