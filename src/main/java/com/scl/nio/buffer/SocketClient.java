package com.scl.nio.buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description
 **********************************/
public class SocketClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(8080));
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put("good mon".getBytes());
        allocate.flip();
        sc.write(allocate);
        allocate.clear();

        sc.close();
    }
}
