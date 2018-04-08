package com.clr;

import com.clr.utils.PathKit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class Test {
    public static void main(String[] args) {
        List<SocketChannel> channels=new ArrayList<SocketChannel>();
        try {
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9090));
            int i=0;
            while (i<10){
                System.out.println("cehsi  "+i);
               SocketChannel channel= serverSocketChannel.accept();
                channels.add(channel);
                i++;
            }
            channels.size();
            Selector sel=Selector.open();
            for (SocketChannel channel : channels) {
                channel.configureBlocking(false);
                channel.register(sel, SelectionKey.OP_READ);
            }
            System.out.println(sel.selectNow()+"finalset");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
