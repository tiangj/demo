package com.example.wwq.controller;


import com.example.wwq.kit.AuthorHelper;
import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqOrderService;
import com.example.wwq.service.IWwqPayService;
import com.example.wwq.service.IWwqProductService;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品支付表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqPay")
public class WwqPayController {

    @Autowired
    private IWwqOrderService wwqOrderService;

    @Autowired
    private IWwqPayService wwqPayService;

    @Autowired
    private AuthorHelper authorHelper;

    /**
     * 订单支付接口
     * @param req
     * @param orderType 下单方式（1：购物车下单;2:商品详情页下单）
     * @param ids 购物车Id（orderType为1时传入）
     * @param postDateId 收货时间
     * @param addressId 收货地址id
     * @param id 商品id（orderType为2时传入）
     * @param buyNum 购买数据量（orderType为2时传入）
     * @param payWay 支付方式
     * @param remark 留言
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest req,
                      @RequestParam(value="orderType",required=true)Integer orderType,
                      @RequestParam(value="shopCartIds",required=true)String ids,
                      @RequestParam(value="postDateId",required=true)String postDateId,
                      @RequestParam(value="addressId",required=false)String addressId,
                      @RequestParam(value="productId",required=true)String id,
                      @RequestParam(value="buyNum",required=true)Integer buyNum,
                      @RequestParam(value="payWay",required=true)Integer payWay,
                      @RequestParam(value="remark",required=true)String remark){
        String renoteAddr = req.getRemoteAddr();
        String userId = authorHelper.getUserId(req);
        if(userId == null){
            return JSONResult.init(301, "success", "user not login");
        }
        List<Map<String, Object>> retList = null;
        //先生成商品订单
        if(orderType == 1){
            retList = wwqOrderService.addShopProductCartOrder(userId, ids, postDateId, payWay, remark,addressId);
        }else{
            retList = wwqOrderService.addShopProductOrder(userId, id, buyNum, postDateId, payWay,remark,addressId);
        }
        System.out.println("订单列表："+retList);
        //再生成支付订单
        String payId = wwqPayService.creatPayOrderRecord(userId, retList);
        if(payId == null){
            return JSONResult.init(500, "支付失败！");
        }
        Map<String, Object> retMap = wwqPayService.wxJSAPIPay(renoteAddr,payId, userId);
        if(retMap == null || retMap.size()<1){
            return JSONResult.init(500, "支付失败！");
        }else{
            return JSONResult.init(200, "success ！", retMap);
        }
    }


    @RequestMapping("/callBack")
    public String callBack(HttpServletRequest req, HttpServletResponse response){
        System.out.println("进入了支付回调");
        String notityXml = "";
        String resXml = "";
        try {
            String inputLine;
            while ((inputLine = req.getReader().readLine()) != null) {
                notityXml = notityXml + inputLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(notityXml)) {
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSONObject json = (JSONObject) xmlSerializer.read(notityXml);
            String return_code = json.getString("return_code");
            if ("SUCCESS".equals(return_code)) {
                String result_code = json.getString("result_code");
                if ("SUCCESS".equals(result_code)) {
                    // 支付成功
                    resXml = "<xml>"
                            + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>"
                            + "</xml> ";
                    System.out.println("resXml-----------"+resXml);
                    String orderId = json.getString("out_trade_no");
                    System.out.println("orderId:"+orderId);
                    //调起更新订单数据
                    wwqPayService.updateOrderStatus(orderId);
                }

            }
        }
        BufferedOutputStream out;
        try {
            out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

