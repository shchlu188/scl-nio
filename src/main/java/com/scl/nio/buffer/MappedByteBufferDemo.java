package com.scl.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description
 **********************************/
public class MappedByteBufferDemo {
    public static void main(String[] args) throws Exception{
        RandomAccessFile raf = new RandomAccessFile("pom.xml","rw");

        FileChannel rafChannel = raf.getChannel();

        MappedByteBuffer mappedByteBuffer = rafChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put("good".getBytes());
    }
}
