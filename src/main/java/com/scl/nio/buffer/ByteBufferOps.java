package com.scl.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description
 **********************************/
public class ByteBufferOps {
    public static void main(String[] args) {
        IntBuffer byteBuffer = IntBuffer.allocate(10);
   /*     byteBuffer.putInt(100);
        byteBuffer.putChar('A');
        // Exception in thread "main" java.nio.BufferOverflowException
        byteBuffer.putDouble(2.3);

        byteBuffer.flip();
        // Exception in thread "main" java.nio.BufferOverflowException
       byteBuffer.getInt();*/
        for (int i = 0; i < 10; i++) {
            byteBuffer.put(i);
        }

        byteBuffer.flip();

        IntBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
//        System.out.println(readOnlyBuffer.get());
        for (int i = 0; i < 10; i++) {
            System.out.println(readOnlyBuffer.get());
        }
//Exception in thread "main" java.nio.ReadOnlyBufferException
//        readOnlyBuffer.put(2);

    }
}
