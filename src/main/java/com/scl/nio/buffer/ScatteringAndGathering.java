package com.scl.nio.buffer;

import javax.xml.transform.Source;
import java.io.DataOutput;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description
 **********************************/
public class ScatteringAndGathering {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress(8080);
        ssc.bind(isa);

        ByteBuffer buf1 = ByteBuffer.allocate(2);
        ByteBuffer buf2 = ByteBuffer.allocate(3);
        ByteBuffer[] bufs = new ByteBuffer[]{buf1,buf2};

        SocketChannel sc = ssc.accept();

        while (sc.read(bufs)!=-1){
            Arrays.stream(bufs).forEach(ByteBuffer::flip);
            System.out.print(new String(bufs[0].array(),0,bufs[0].limit()));
            System.out.print(new String(bufs[1].array(),0,bufs[1].limit()));

            Arrays.stream(bufs).forEach(ByteBuffer::clear);

            }
        System.out.println();
        Arrays.stream(bufs).forEach(byteBuffer -> System.out.println(byteBuffer.position()+"=="+byteBuffer.limit()+"=="+byteBuffer.capacity()));
        }


    }

