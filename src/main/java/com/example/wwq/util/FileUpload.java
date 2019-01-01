package com.example.wwq.util;

import com.example.wwq.entity.WwqProductFile;
import com.example.wwq.service.IWwqBannerService;
import com.example.wwq.service.IWwqProductFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FileUpload {

    @Autowired
    private IWwqProductFileService productFileService;

    @Autowired
    private IWwqBannerService bannerService;

    /**
     * @function 多文件上传
     * @return
     */
    public static List<String> fileMany(MultipartFile[] files , String saveUrl){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        List<String> picUrl = new ArrayList<>();
        String newUrl = saveUrl + "\\" + simpleDateFormat.format(new Date()) + "\\pic\\";
        File saveDir = new File(newUrl);
        if(!saveDir.exists()){
            saveDir.mkdirs();
        }
        for(MultipartFile file : files){
            if(file != null){
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String fileName = UUID.randomUUID().toString().replace("-","") + suffix;
                String newFileUrl = newUrl+fileName;
                File saveFile = new File(newFileUrl);
                try {
                    file.transferTo(saveFile);
                    picUrl.add(newFileUrl);

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("上传失败");
                }
            }
        }
        System.out.println(picUrl);
        return picUrl;
    }

}
