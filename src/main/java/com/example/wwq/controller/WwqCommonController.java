package com.example.wwq.controller;

import com.example.config.ConstantUtil;
import com.example.wwq.entity.WwqBanner;
import com.example.wwq.entity.WwqProductFile;
import com.example.wwq.service.IWwqBannerService;
import com.example.wwq.service.IWwqProductFileService;
import com.example.wwq.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****
 * 公用controller
 */
@Controller
@RequestMapping("/common")
public class WwqCommonController {

    @Value("${upload.file.path}")
    private String filePath;

    @Value("${upload.file.type}")
    private String fileType;

    @Value("${base.uploadFile.server}")
    private String baseFileServer;

    @Autowired
    private IWwqBannerService bannerService;

    @Autowired
    private IWwqProductFileService productFileService;

    /****
     * 图片上传
     * @param files:文件对象
     * @param id:关联主表id
     * @param type:上传图片所属类型:product:商品,bannner:商品
     * @param fileType:对应图片表中的图片所属类型
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam(value = "file", required = false) MultipartFile[] files,String id,String type,Integer fileType, HttpServletRequest request){
        String userId=request.getSession().getAttribute(ConstantUtil.SEESION_USER_ID).toString();
        String userName=request.getSession().getAttribute(ConstantUtil.SESSION_USER_NAME).toString();
        Map<String,Object> result=new HashMap<>();
        if(files.length == 0){
            //return Msg.fail().add("msg", "图片为空！");
            result.put("code",0);
            result.put("msg","图片为空！");
        }else{
            List<String> lists = FileUpload.fileMany(files,filePath,baseFileServer);
            result.put("code",1);
            result.put("msg","成功");
            result.put("picUrl",lists);

            for(String string:lists){
                //保持图片信息至数据库
                if("product".equals(type)){
                    WwqProductFile wwqProductFile=new WwqProductFile();
                    wwqProductFile.setProductId(id);
                    wwqProductFile.setFileType(fileType);
                    wwqProductFile.setFilePath(string);
                    wwqProductFile.setCreateDate(new Date());
                    wwqProductFile.setCreateUser(userId);
                    wwqProductFile.setUpdateDate(new Date());
                    wwqProductFile.setUpdateUser(userId);
                    productFileService.insert(wwqProductFile);
                }else if("banner".equals(type)){
                    WwqBanner wwqBanner=new WwqBanner();
                    wwqBanner.setFilePath(string);
                    wwqBanner.setCreateDate(new Date());
                    wwqBanner.setCreateUser(userId);
                    wwqBanner.setUpdateDate(new Date());
                    wwqBanner.setUpdateUser(userId);
                    bannerService.insert(wwqBanner);
                }
            }
        }
        return result;
    }
}
