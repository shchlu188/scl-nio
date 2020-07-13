package com.scl.nio.buffer;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description channel
 *              双向
 *              FileChannel
 *                  <p>
 *                      read(ByteBuffer dst) Reads a sequence of bytes from this channel into the given buffer.
 *                                           从Channel中读取数据到buffer
 *                       write(ByteBuffer src) Writes a sequence of bytes to this channel from the given buffer.
 *                                            将buffer中的数据写入channel
 *                       transferFrom(ReadableByteChannel src,long position, long count)
 *
 *                  </p>
 *              ServerSocketChannel\SocketChannel
 *
 *
 **********************************/
public class BasicChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("pom.xml"));
        FileOutputStream fos = new FileOutputStream(new File("demo.xml"),true);

        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (fisChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();

        }

        // release
        fis.close();
        fos.close();
    }

    private static void readDataFromFile() throws IOException {
        FileInputStream fis = new FileInputStream(new File("pom.xml"));
        ByteBuffer byteBuffer = ByteBuffer.allocate(14);
        FileChannel fisChannel = fis.getChannel();
        int len = -1;
        while ((len = fisChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.print(new String(byteBuffer.array(), 0, byteBuffer.limit()));
            byteBuffer.clear();
        }
        fis.close();
        System.out.println("successful");
    }

    private static void writeStringToFile() throws IOException {
        String str = "channel demo file";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileOutputStream fos = new FileOutputStream(new File("demo.xml"));
        FileChannel fosChannel = fos.getChannel();
        buffer.put(str.getBytes());
        buffer.flip();
        fosChannel.write(buffer);

        fos.close();
    }

    private static void channel01() throws IOException {
        FileChannel channel = new FileInputStream(new File("pom.xml")).getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.printf("【Init buffer】： pos = %d;\t limit=%d;\t cap=%d\n", byteBuffer.position(), byteBuffer.limit(), byteBuffer.capacity());
        channel.read(byteBuffer);
        System.out.printf("【write buffer】： pos = %d;\t limit=%d;\t cap=%d\n", byteBuffer.position(), byteBuffer.limit(), byteBuffer.capacity());
        byteBuffer.flip();
        System.out.printf("【flip buffer】： pos = %d;\t limit=%d;\t cap=%d\n", byteBuffer.position(), byteBuffer.limit(), byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.printf("%c", byteBuffer.get());
        }
        System.out.println();
        System.out.printf("【display buffer】： pos = %d;\t limit=%d;\t cap=%d\n", byteBuffer.position(), byteBuffer.limit(), byteBuffer.capacity());
        channel.close();
    }
}
