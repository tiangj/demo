package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqCart")
public class WwqCartController {


    @Autowired
    private IWwqCartService wwqCartService;

    /**
     * 添加购物车
     * @param productId 商品id
     * @param buyNum 购买数量
     * @return
     */
    @RequestMapping(value="/addShopCart",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addShopCart(HttpServletRequest req, @RequestParam(value="productId",required=true)String productId,
                              @RequestParam(value="buyNum",required=true)Integer buyNum){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        int ret = wwqCartService.addShopCart(productId, buyNum, userId);
        if(ret > 0){
            return JSONResult.init(200, "success", ret);
        }else{
            return JSONResult.init(500, "false",0);
        }
    }


    /**
     * 购物车列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/shopProductCartList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String shopProductCartList(HttpServletRequest req,@RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        Map<String, Object> pageShopProductCart = wwqCartService.shopProductCartList(userId, pageNum, pageSize);
        return JSONResult.init(200, "success", pageShopProductCart);
    }


    /**
     *修改购物车数量
     * @param shopCartId 购物车id
     * @param num 商品数量
     * @return
     */
    @RequestMapping(value="/modifyShopCartProductNum",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String modifyShopCartProductNum(HttpServletRequest req,@RequestParam(value="shopCartId",required=true)String shopCartId,
                                           @RequestParam(value="productNum",required=true)Integer num){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        int ret = wwqCartService.modifyShopCartProductNum(shopCartId, num,userId);
        if(ret == 500){
            return JSONResult.init(500, "fail");
        }else{
            return JSONResult.init(200, "success", ret);
        }
    }


    /**
     * 删除购物车
     * @param shopCartId
     * @return
     */
    @RequestMapping(value="/deleteShopCartProduct",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String deleteShopCartProduct(HttpServletRequest req,@RequestParam(value="shopCartId",required=true)String shopCartId){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        int ret = wwqCartService.deleteShopCartProduct(shopCartId);
        return JSONResult.init(200, "success",ret);
    }


    @RequestMapping(value="/shopCartProductNum",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String shopCartProductNum(HttpServletRequest req){
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if(userId == null){
//            return JSONResult.init(301, "success", "user not login");
//        }
        Integer numList = wwqCartService.shopCartProductNum(userId);
        return JSONResult.init(200, "success", numList);
    }
}

