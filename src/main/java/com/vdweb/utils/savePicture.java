package com.vdweb.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class savePicture {
    private String filePath="D:/graduationproject/vddemp/public/picture/picture/"; //定义上传文件的存放位置

    public String upLoadFile(MultipartFile upload,String newName) {
        //判断文件夹是否存在,不存在则创建
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFileName = upload.getOriginalFilename();//获取原始图片的扩展名
        String newFileName = UUID.randomUUID()+newName + originalFileName;
        String newFilePath = filePath + newFileName; //新文件的路径
        try {
            upload.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件
            return newFileName;
        } catch (IllegalStateException e) {
            //处理异常
        } catch (IOException e1) {
            //处理异常
        }
        return null;
    }
}
