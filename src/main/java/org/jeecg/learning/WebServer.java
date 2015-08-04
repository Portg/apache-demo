package org.jeecg.learning;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.jeecg.learning.util.PropertiesHelper;
import org.jeecg.learning.util.PropertiesLoader;


public class WebServer {

    private static final PropertiesHelper props = new PropertiesHelper(PropertiesLoader
            .loadProperties());

    /**
     * 启动web服务器
     * 
     * @param port 服务器端口号
     */
    public void startup(int port) {

        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                socket = serverSocket.accept();
                new Processor(socket, props).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(socket != null) {
                    socket.close();
                }
            }catch(IOException e){
                e.printStackTrace();}
        }
    }

    public static void main(String[] args) {

        int port = props.getInt("server.port", 90);
        if(args.length == 1){
            port = Integer.parseInt(args[0]);
        }
        new WebServer().startup(port);

    }

}
