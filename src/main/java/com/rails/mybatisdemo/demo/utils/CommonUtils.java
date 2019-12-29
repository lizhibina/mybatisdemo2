package com.rails.mybatisdemo.demo.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @author
 * @date 2019/3/28 15:05
 * @description 工具类
 */
@Component
public class CommonUtils {
   public static String uuid(){
       return UUID.randomUUID().toString().replaceAll("-", "");
   }
   public static String springBootDevTest(String abcd){
       return abcd.replace("a","h");
   }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        System.out.println("上传成功");
        out.write(file);
        out.flush();
        out.close();
    }
}