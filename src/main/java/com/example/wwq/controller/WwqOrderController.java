package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqOrderService;
import com.github.pagehelper.PageInfo;
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
 * 订单表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqOrder")
public class WwqOrderController {


//    @Autowired
//    private IWwqOrderService wwqOrderService;
//
//    /**
//     * 从购物车下预定单
//     * @param req
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value="/addShopCartProductCartPreOrder",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public String addShopCartProductCartPreOrder(HttpServletRequest req, @RequestParam(value="shopCartIds",required=true)String ids){
//        String userId = "1";
//        List<Map<String, Object>> retList = wwqOrderService.addShopCartProductCartPreOrder(ids,userId);
//        if(retList == null || retList.size() < 1){
//            return JSONResult.init(500, "fail",null);
//        }else{
//            return JSONResult.init(200, "success",retList);
//        }
//    }
//
//
//    /**
//     * 从商品详情下预定单
//     * @param req
//     * @param id 商品id
//     * @param buyNum 购买数量
//     * @return
//     */
//    @RequestMapping(value="/addProductToOrder",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public String addProductToOrder(HttpServletRequest req,@RequestParam(value="productId",required=true)String id,
//                                    @RequestParam(value="buyNum",required=true)Integer buyNum){
//        String userId = "1";
//        Map<String, Object> retMap = wwqOrderService.addProductToOrder(id, buyNum,userId);
//        if(retMap == null || retMap.size()<1){
//            return JSONResult.init(500, "fail",null);
//        }else{
//            return JSONResult.init(200, "success",retMap);
//        }
//    }
//
//    /**
//     * 用户订单列表
//     * @param req
//     * @param orderStatus 订单状态（0：全部）
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @RequestMapping(value="/shopProductOrderList",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public String shopProductOrderList(HttpServletRequest req,
//                                       @RequestParam(value="type",required=true)Integer orderStatus,
//                                       @RequestParam(value="pageNum",defaultValue="1",required=true) Integer pageNum,
//                                       @RequestParam(value="pageSize",defaultValue="10",required=true) Integer pageSize){
//        String userId = "1";
////        String userId = authorHelper.getUserId(req);
////        if(userId == null){
////            return JSONResult.init(301, "success", "user not login");
////        }
//        PageInfo<Map<String, Object>> page = wwqOrderService.shopProductOrderList(userId,orderStatus, pageNum, pageSize);
//        return JSONResult.init(200, "success",page);
//    }
//
//
//    /**
//     * 根据订单状态获得状态数量（已改）
//     * @return
//     */
//    @RequestMapping(value="getStatusNumBystatus",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public String getStatusNumBystatus(HttpServletRequest req){
//        String userId = "1";
////        String userId = authorHelper.getUserId(req);
////        if(userId == null){
////            return JSONResult.init(301, "success", "user not login");
////        }
//        Map<String, Object> Nummap= wwqOrderService.getStatusNumBystatus(userId);
//        return JSONResult.init(200, "success",Nummap);
//    }
//
//
//    /**
//     * 订单详情
//     * @param req
//     * @param orderId 订单id
//     * @param orderStatus
//     * @return
//     */
//    @RequestMapping(value="/shopProductOrderDetail",produces="text/html;charset=UTF-8")
//    @ResponseBody
//    public String shopProductOrderDetail(HttpServletRequest req,@RequestParam(value="orderId",required=true)String orderId,
//                                         @RequestParam(value="orderStatus",required=true)Integer orderStatus){
//		String userId = "1";
////        String userId = authorHelper.getUserId(req);
////        if(userId == null){
////            return JSONResult.init(301, "success", "user not login");
////        }
//        List<Map<String,Object>> shopProduct = wwqOrderService.shopProductOrderDetail(userId,orderId,orderStatus);
//        return JSONResult.init(200, "success",shopProduct);
//    }
}

