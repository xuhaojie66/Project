package com.xufeng;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


class Tomcat implements Runnable{
    //为了提高服务的效率，把每一个用户的请求都包装成一个线程
    private Socket socket;
    public Tomcat(Socket socket) {//传递为用户服务的客服对象
        this.socket = socket;
    }
    public void run() {
        InputStream in=null;
        OutputStream out=null;
        try {
            in=this.socket.getInputStream();
            out=this.socket.getOutputStream();
            byte[] buff=new byte[1024];
            int len=in.read(buff);//返回读到的字节数
            //把读取到的字节数转换成字符串
            String request=new String(buff,0,len);
            request=request.substring(0,request.indexOf("\r\n"));
            request=request.split(" ")[1];
            request=request.substring(1);
            System.out.println(request);
            //在服务器端查找该资源是否存在，如果存在则输出给客户端，如果不存在给客户一个响应提示信息
            //把该资源包装成一个文件
            File file=new File("src/"+request);
            if(file.exists()){
                //资源存在则把资源以流的形式传给客户端
                FileInputStream fis=new FileInputStream(file);
                while((len=fis.read(buff))>0){
                    out.write(buff,0,len);
                }
                fis.close();
            }else{//资源不存在
                if(out!=null){
                    String info="<h1><font colour='red'>对不起，您请求的资源不存在</font></h1>";
                    out.write(info.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
//java程序模拟Tomcat
public class TomcatImtate {
       public static void main(String[] args)  {
        try {
            //创建一个服务器的socket
            ServerSocket socket= new ServerSocket(8081);
            while(true){
                //获取为客户请求服务的一个对应socket
                Socket client=socket.accept();
                //把该socket包装成一个线程
                new Thread(new Tomcat(client)).start();
//                //获取用户的请求（输入流对象）
//                InputStream in=client.getInputStream();
//                //获取一个响应的输出流对象（为用户提供输出服务）
//                OutputStream out=client.getOutputStream();
//                //首先读取该用户的请求信息
//                byte[] buff=new byte[1024];
//                int len=in.read(buff);//返回读到的字节数
//                //把读取到的字节数转换成字符串
//                String request=new String(buff,0,len);
//                request=request.substring(0,request.indexOf("\r\n"));
//                request=request.split(" ")[1];
//                request=request.substring(1);
//                System.out.println(request);
//                //在服务器端查找该资源是否存在，如果存在则输出给客户端，如果不存在给客户一个响应提示信息
//                //把该资源包装成一个文件
//                File file=new File("src/"+request);
//                if(file.exists()){
//
//                }else{//资源不存在
//                    if(out!=null){
//                        String info="<h1><font colour='red'>对不起，您请求的资源不存在</font></h1>";
//                        out.write(info.getBytes());
//                    }
//                }
//                out.close();
//                in.close();
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
