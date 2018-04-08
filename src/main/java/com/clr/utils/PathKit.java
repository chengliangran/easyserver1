package com.clr.utils;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */
public class PathKit {

    public static String webContent=System.getProperty("user.dir").toString()+ File.separator+"src/main/webapp";

    public static String webInf=webContent+File.separator+"WEB-INF";

    public static void main(String[] args) {
        System.out.println(webContent);
    }

    public static void delete(File file){
        if (file.exists()){
            if (file.isFile()){
                file.delete();
            }else {
                File[] files= file.listFiles();
                for (File file1 : files) {
                    delete(file);
                }
                file.delete();
            }
        }
    }


}
