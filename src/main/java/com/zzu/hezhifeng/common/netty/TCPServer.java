package com.zzu.hezhifeng.common.netty;

import com.zzu.hezhifeng.pojo.DO.DataObj;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;


@Configuration
public class TCPServer {
    @Value("8081")
    private String port;
    private Socket accept = null;

    public DataObj readMsg() throws IOException {
        StringBuffer readMsg = new StringBuffer();
        Integer len = 0;
        if (accept == null){
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            accept = serverSocket.accept();
        }
        InetAddress fromAddr = accept.getInetAddress();
        String hostAddress = fromAddr.getHostAddress();
        InputStream is = accept.getInputStream();
        byte[] bytes =new byte[1024];
        while ((len = is.read(bytes)) > 0){
            readMsg.append(new String(bytes, 0, len));
        }
        //拿到源地址 + massage 后
        DataObj data = new DataObj();
        data.setHostAddress(hostAddress);
        data.setMessage(readMsg.toString());
        return data;
    }

    public void writeMsg(String ip, Integer port, String msg) throws IOException {
        Socket socket = new Socket(ip, port);
        OutputStream os = socket.getOutputStream();
        os.write(msg.getBytes());
        os.close();
    }
}
