package com.clr.connector.http;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class HTTPGet {
    String REQUEST_LINE_SUCCESS="HTTP/1.1 200 OK\n";
    String HEADER_SERVER="Server: easyserver\n";
    String DATE="Date:\n";
    String HEADER_CONTENT_LENGTH="";
    String HEADER_CONTENT_TYPE="";
    String HEADER_CONNECTION_KEEP="";
    String STATUS="200 OK                        //客户端请求成功\n" +
            "400 Bad Request               //客户端请求有语法错误，不能被服务器所理解\n" +
            "401 Unauthorized              //请求未经授权，这个状态代码必须和WWW-Authenticate报头域一起使用 \n" +
            "403 Forbidden                 //服务器收到请求，但是拒绝提供服务\n" +
            "404 Not Found                 //请求资源不存在，eg：输入了错误的URL\n" +
            "500 Internal Server Error     //服务器发生不可预期的错误\n" +
            "503 Server Unavailable        //服务器当前不能处理客户端的请求，一段时间后可能恢复正常";

   public static String finishResp() {
        String resp="HTTP/1.1 200 OK\n" +
                "Content-Length: 7\n" +
                "Connection: Keep-Alive\n" +
                "Content-Type: text/html; charset=UTF-8\n" +
                "\n" +
                "success";
        return resp;
    }

    public static void main(String[] args) {
        System.out.println("success".getBytes().length);
    }
}
