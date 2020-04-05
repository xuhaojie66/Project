package com.xufeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/downloads")
public class contextDownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //需要下载的文件名
        String filename="你菜炸了吗App—前景与范围文档.docx";
        //因为文件名为中文名，需要设置utf-8编码
        //为了实现页面弹出一个对话框，我们需要设置响应头文件
        response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"utf-8"));
        //获取文件的绝对路径
        String filepath=this.getServletContext().getRealPath("/downloads/"+filename);
        System.out.println(filepath);
        //获取该路径的输入流对象
        InputStream fin=this.getServletContext().getResourceAsStream("/downloads/"+filename);
        //读文件
        //要从输入流中读取数据，为了提高效率我们一次可以读取多个字符
        byte[] buffer=new byte[1024];//用来存放读取到的字符数
        int len=-1;
        //获取向客户端输出的字节流对象
        OutputStream out=response.getOutputStream();
        //实现文件的拷贝功能
        while ((len=fin.read(buffer))>0){
            //把读取出来的字节写给客户端
            out.write(buffer,0,len);
        }
        //释放资源
        fin.close();
        out.close();
    }
}