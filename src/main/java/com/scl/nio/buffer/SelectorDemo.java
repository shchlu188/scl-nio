package com.scl.nio.buffer;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/13
 * @Description selector 选择器
 *
 *              SelectorImpl
 *                      Set<SelectionKey> keys;
 *                      Set<SelectionKey> selectedKeys;
 *                      Set<SelectionKey> publicKeys;
 *                      Set<SelectionKey> publicSelectedKeys;
 *      1、客户端连接时，会通过ServerSocketChannel得到SocketChannel
 *      2、将socketChannel注册到Selector上,通过 SelectionKey register(Selector sel, int ops),一个selector可以注册多个SocketChannel
 *      3、注册之后会返回SelectionKey,会和Selector进行关联
 *      4、Selector进行监听select方法，返回该事件发生的通道个数
 *      5、进一步得到各个SelectionKey(发生事件的）
 *      6、再通过SelectionKey反向获取SocketChannel方法channel（）
 *      7、可以通过channel，来完成业务处理
 *
 **********************************/
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc  = ServerSocketChannel.open();

    }
}
