package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqProductCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 商品评论表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqProductComment")
public class WwqProductCommentController {

@Autowired
private IWwqProductCommentService wwqProductCommentService;

    /**
     * 商品评论列表
     * @param praise
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopProductCommentListById",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String shopProductCommnetListById(@RequestParam(value="praise",defaultValue="0",required=true) Integer praise,
                                             @RequestParam(value="productId",required=true) String id,
                                             @RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                             @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        PageInfo<Map<String,Object>> pageShopProductCommnet = wwqProductCommentService.shopProductCommentList(id, praise,pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopProductCommnet);
    }


    @RequestMapping(value="/getShopProductCommentNum",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getShopProductCommentNum(@RequestParam(value="productId",required=true) String id){
        Map<String, Object> retMap = wwqProductCommentService.getShopProductCommentNum(id);
        return JSONResult.init(200, "success",retMap);
    }


    /**
     *添加商品评论
     * @param id 商品id
     * @param praise 评价等级（1；2；3）
     * @param content 评论内容
     * @return
     */
    @RequestMapping(value="/addShopProductComment",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addShopProductComment(HttpServletRequest req, @RequestParam(value="productId",required=true) String id,
                                        @RequestParam(value="praise",required=true) Integer praise,
                                        @RequestParam(value="content",required=true) String content){
        String userId = "1";
        //String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        int ret = wwqProductCommentService.addShopProductComment(id, userId, content, praise);
        return JSONResult.init(200, "success", ret);
    }
}

