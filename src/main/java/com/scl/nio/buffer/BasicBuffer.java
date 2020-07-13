package com.scl.nio.buffer;

import java.nio.IntBuffer;
import java.util.Arrays;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description Buffer
 *     // Invariants: mark <= position <= limit <= capacity
 *     private int mark = -1;
 *     private int position = 0;
 *     private int limit;
 *     private int capacity;
 *
 *     总结
 *          1 每个channel对应一个buffer
 *          2 selector 对应一个线程, 一个线程对应多个channel
 *          3 将channel注册到selector
 *          4 selector 根据不同事件，在通道上进行切换
 *          5 程序切换通道是根据事件进行切换
 *          6 Buffer 是内存块，底层是数组
 *          7 数据的读入写出是通过Buffer
 *          8 channel是双向的
 *
 **********************************/
public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(20);
        // init value:  pos =0 ; lim=cap=20
        System.out.printf("【init State】： pos = %d;\t limit=%d;\t cap=%d\n",intBuffer.position(),intBuffer.limit(),intBuffer.capacity());

        // save data
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }
        System.out.printf("【Save Data】： pos = %d;\t limit=%d;\t cap=%d\n",intBuffer.position(),intBuffer.limit(),intBuffer.capacity());

        // read data, write ops --> read ops
        intBuffer.flip(); // limit = pos; pos = 0 ; mark = -1
//        intBuffer.position(0);
        System.out.printf("【filp State】： pos = %d;\t limit=%d;\t cap=%d\n",intBuffer.position(),intBuffer.limit(),intBuffer.capacity());
            intBuffer.position(10);
            intBuffer.limit(15);
      /*  while (intBuffer.hasRemaining()) { //  position < limit;
            System.out.println(intBuffer.get());

        }*/
        System.out.println("【获取缓冲区数组】"+Arrays.toString(intBuffer.array()));
        System.out.println("【获取当前索引的值，并且pos自增1】"+intBuffer.get());
        System.out.println("【指定获取数组索引中的值】"+intBuffer.get(7));
        System.out.printf("【read State】： pos = %d;\t limit=%d;\t cap=%d\n",intBuffer.position(),intBuffer.limit(),intBuffer.capacity());

    }
}
