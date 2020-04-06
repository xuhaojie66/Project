package com.xufeng;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//java程序模拟Tomcat
public class TomcatImtate {
    //创建一个服务器的socket
    ServerSocket socket;

    {
        try {
            socket = new ServerSocket(8080);
            //获取为客户请求服务的一个对应socket
            Socket client=socket.accept();
            //获取用户的请求（输入流对象）
            InputStream in=client.getInputStream();
            //获取一个响应的输出流对象（为用户提供输出服务）
            OutputStream out=client.getOutputStream();
            //首先读取该用户的请求信息
            byte[] buff=new byte[1024];
            int len=in.read(buff);//返回读到的字节数
            //把读取到的字节数转换成字符串
            String request=new String(buff,0,len);
            System.out.println(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
