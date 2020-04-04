package com.xhj.webserver;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
class Tomcat implements Runnable{
    private Socket socket;

    public Tomcat(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in=null;
        OutputStream out = null;
        try {
            in=this.socket.getInputStream();
            out=this.socket.getOutputStream();
            if(in!=null){
                byte[] buff = new byte[4096];
                int len = in.read(buff);
                String request = new String(buff,0,len);
                request = request.substring(0,request.indexOf("\r\n"));
                request = request.split(" ")[1];
                request = request.substring(1);
                File file = new File("src/" + request);
                System.out.println(request);
                if(file.exists()){
                    FileInputStream fout = new FileInputStream(file);
                    while ((len=fout.read(buff))>0){
                        out.write(buff,0,len);
                    }
                    fout.close();
                }
                else {
                    if(out!=null){
                        String info = "<h1><font color='red'>对不起，您请求的路径不存在！</font></h1>";
                        out.write(info.getBytes());
                    }
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
public class TomcatMoni {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true){
                Socket client = serverSocket.accept();
                new Thread(new Tomcat(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
