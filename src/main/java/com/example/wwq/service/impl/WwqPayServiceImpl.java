package com.example.wwq.service.impl;

import com.example.wwq.entity.*;
import com.example.wwq.mapper.*;
import com.example.wwq.pay.kit.*;
import com.example.wwq.service.IWwqPayService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 商品支付表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqPayServiceImpl extends ServiceImpl<WwqPayMapper, WwqPay> implements IWwqPayService {


    @Autowired
    private WwqProductMapper wwqProductMapper;

    @Autowired
    private WwqPayMapper wwqPayMapper;

    @Autowired
    private WwqPayDetailMapper wwqPayDetailMapper;

    @Autowired
    private WwqUserMapper wwqUserMapper;

    @Autowired
    private WwqOrderMapper wwqOrderMapper;

    @Autowired
    private WwqOrderDetailMapper wwqOrderDetailMapper;

    @Autowired
    private WwqOrderScoreMapper wwqOrderScoreMapper;

    @Autowired
    private WwqShareUserConcartMapper wwqShareUserConcartMapper;

    @Autowired
    private WwqUserShareAmountMapper wwqUserShareAmountMapper;

    @Autowired
    private WwqUserShareAmountDetailMapper wwqUserShareAmountDetailMapper;

    @Autowired
    private WwqShareCountMapper wwqShareCountMapper;

    @Transactional
    @Override
    public String creatPayOrderRecord(String userId, List<Map<String, Object>> orderList) {
        BigDecimal totalPrice = new BigDecimal(0);
        // 计算运费
        BigDecimal totalPostPrice = new BigDecimal(0);
        BigDecimal postPrice = new BigDecimal(0);
        for (int i = 0; i < orderList.size(); i++) {
            WwqProduct product = wwqProductMapper.selectById(orderList.get(i).get("product_id").toString());
            if (product.getPostPrice().compareTo(new BigDecimal(0)) == 0) {
                System.out.println("快递费为0");
                postPrice = new BigDecimal(0);
            } else {
                postPrice = product.getPostPrice();
                System.out.println("快递费不为0:"+postPrice);
            }
            totalPostPrice = totalPostPrice.add(postPrice);
            System.out.println("总快递费用："+totalPostPrice);
        }
        WwqPay shopPay = new WwqPay();
        shopPay.setCreateDate(new Date());
        shopPay.setCreateUser(userId);
        shopPay.setUpdateDate(new Date());
        shopPay.setUpdateUser(userId);
        shopPay.setPayStatus(100);
        shopPay.setPayName("NO"+new SimpleDateFormat("yyyyddmmHHMMss").format(new Date()));
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println("计算订单运费");
            totalPrice = totalPrice.add(new BigDecimal(orderList.get(0)
                    .get("orderPrice").toString()));
        }
        //支付订单总价：订单总价+快递总费用
        totalPrice = totalPrice.add(totalPostPrice);
        shopPay.setTotalPrice(totalPrice.toString());
        shopPay.setUserId(userId);
        //计算积分
        BigDecimal consumePoint = new BigDecimal(0);
        if(totalPrice.compareTo(new BigDecimal(500)) >= 0){
            consumePoint = new BigDecimal(500).multiply(totalPrice.divide(new BigDecimal(500)).setScale(0,java.math.BigDecimal.ROUND_DOWN)).multiply(new BigDecimal(1.8));
        }
        shopPay.setConsumePoint(consumePoint.intValue());
        wwqPayMapper.insert(shopPay);
        // 创建支付订单详情
        for (int i = 0; i < orderList.size(); i++) {
            WwqPayDetail shopPayDetail = new WwqPayDetail();
            shopPayDetail.setCreateDate(new Date());
            shopPayDetail.setCreateUser(userId);
            shopPayDetail.setPayId(shopPay.getId());
            shopPayDetail.setOrderId(orderList.get(i).get("orderId").toString());
            shopPayDetail.setUpdateDate(new Date());
            shopPayDetail.setUpdateUser(userId);
            wwqPayDetailMapper.insert(shopPayDetail);
        }
        return shopPay.getId();
    }

    @Transactional
    @Override
    public Map<String, Object> wxJSAPIPay(String renoteAddr,String payId,String userId) {
        //查询商品支付订单信息
        WwqPay shopPay = wwqPayMapper.selectById(payId);
        if(shopPay == null){
            return null;
        }
        //查询用的openId
        WwqUser shopUser = wwqUserMapper.selectById(userId);
        if(shopUser == null){
            return null;
        }
        //构建支付参数
        String body = shopPay.getPayName();
        String totalFee = shopPay.getTotalPrice();
        String openid = shopUser.getOpenId();

        try {
            Map<String, Object> payPackage = this.postOrder(body, payId, totalFee, renoteAddr, openid);
            return payPackage;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Transactional
    @Override
    public boolean updateOrderStatus(String payId) {
        //查询支付订单是否存在
        WwqPay wwqPay = wwqPayMapper.selectById(payId);
        if(wwqPay == null){
            return false;
        }
        //先更新支付主表的支付状态
        WwqPay shopPay = new WwqPay();
        shopPay.setId(payId);
        shopPay.setPayStatus(200);
        wwqPayMapper.updateById(shopPay);
        //查询当前支付订单对应的商品订单
        List<WwqPayDetail> shopPayList = wwqPayDetailMapper.getPayOrderList(payId);
        if(shopPayList == null || shopPayList.size() < 1){
            return false;
        }
        for(int i = 0 ;i < shopPayList.size();i++) {
            String orderId = shopPayList.get(i).getOrderId();
            //查询订单详情
            WwqOrder shopOrder1 = wwqOrderMapper.selectById(orderId);
            if (shopOrder1 == null) {
            }
            //更新订单主表
            WwqOrder shopOrder = new WwqOrder();
            shopOrder.setId(orderId);
            shopOrder.setOrderStatus(200);
            shopOrder.setPayStatus(200);
            shopOrder.setPayWay(102);
            wwqOrderMapper.updateById(shopOrder);
            //新建订单详情
            WwqOrderDetail shopOrderDetail = new WwqOrderDetail();
            shopOrderDetail.setCreateDate(new Date());
            shopOrderDetail.setCreateUser(shopOrder1.getUserId());
            shopOrderDetail.setOrderId(orderId);
            shopOrderDetail.setOrderStatus(200);
            shopOrderDetail.setUpdateDate(new Date());
            shopOrderDetail.setUpdateUser(shopOrder1.getUserId());
            wwqOrderDetailMapper.insert(shopOrderDetail);
            //积分操作,建22条积分返现记录
            if(wwqPay.getConsumePoint() <= 0){
                return true;
            }
            //BigDecimal avPoint = new BigDecimal(wwqPay.getConsumePoint()).divide(new BigDecimal(22)).setScale(0,java.math.BigDecimal.ROUND_DOWN);
            //.divide(settleAmount,4,RoundingMode.HALF_UP));
            BigDecimal avPoint = new BigDecimal(wwqPay.getConsumePoint()).divide(new BigDecimal(22),0, RoundingMode.DOWN);
            BigDecimal lastPoint = new BigDecimal(500).subtract(avPoint.multiply(new BigDecimal(22)));
            for(int j = 0;j < 22;j++) {
                WwqOrderScore wwqOrderScore = new WwqOrderScore();
                wwqOrderScore.setCreateDate(new Date());
                wwqOrderScore.setCreateUser(wwqPay.getCreateUser());
                wwqOrderScore.setDeleteFlag(0);
                wwqOrderScore.setExecuteFlag(0);
                if(j ==21) {
                    wwqOrderScore.setIntegral(lastPoint.intValue());
                }else{
                    wwqOrderScore.setIntegral(avPoint.intValue());
                }
                wwqOrderScore.setOrderId(payId);
                wwqOrderScore.setSort(j);
                wwqOrderScore.setUpdateDate(new Date());
                wwqOrderScore.setUpdateUser(wwqPay.getUpdateUser());
                wwqOrderScore.setUserId(wwqPay.getUserId());
                wwqOrderScoreMapper.insert(wwqOrderScore);
            }
        }
        //分销返利
        //查找当前下单用户是否存在上级
        //如果有上级，则上级直接拿3%的佣金
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",wwqPay.getUserId());
        map.put("delete_flag",0);
        List<WwqShareUserConcart> list = wwqShareUserConcartMapper.selectByMap(map);
        if(list == null || list.size()<1){
            return true;
        }
        BigDecimal shareAmount = new BigDecimal(wwqPay.getTotalPrice()).multiply(new BigDecimal(0.3));
        this.updateUserShareAmountConcart(list.get(0).getParentId(),shareAmount);
        //查询当前用户的上级是否存在上级
        Map<String,Object> map1 = new HashMap<>();
        map1.put("user_id",list.get(0).getParentId());
        map1.put("delete_flag",0);
        List<WwqShareUserConcart> list1 = wwqShareUserConcartMapper.selectByMap(map1);
        if(list1 == null || list1.size()<1){
            return true;
        }
        //如果存在，判断上级的上级是否有12个直接下级，以及所有一二级下级是否有120个人
        Map<String,Object> map2 = new HashMap<>();
        map2.put("user_id",list1.get(0).getParentId());
        map2.put("delete_flag",0);
        List<WwqShareCount> list2 = wwqShareCountMapper.selectByMap(map2);
        if(list2 == null || list2.size()<1){
            return true;
        }
        //如果符合这个条件，则上级的上级也拿走3%
        if(list2.get(0).getFirstShareNum() > 12 && list2.get(0).getSecondShareNum() > 120){
            this.updateUserShareAmountConcart(list1.get(0).getParentId(),shareAmount);
        }
        return true;
    }


    public boolean updateUserShareAmountConcart(String userId,BigDecimal shareAmount){
        //根据openId查询用户的id
        Map<String,Object> map1 = new HashMap<>();
        map1.put("openid",userId);
        List<Map<String,Object>> list1 = wwqUserMapper.selectInfoById(map1);
        if(list1 == null || list1.size() < 1){
            return false;
        }
        //查询当前用户是否有记录
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",list1.get(0).get("id"));
        map.put("delete_flag",0);
        List<WwqUserShareAmount> list = wwqUserShareAmountMapper.selectByMap(map);
        if(list == null || list.size()<1){
            WwqUserShareAmount amount = new WwqUserShareAmount();
            amount.setCreateDate(new Date());
            amount.setCreateUser(userId);
            amount.setDeleteFlag(0);
            amount.setHasWithdrawalAmount(new BigDecimal(0));
            amount.setTotalShareAmount(shareAmount);
            amount.setUpdateDate(new Date());
            amount.setUpdateUser(userId);
            amount.setWithdrawalAmount(shareAmount);
            amount.setUserId(userId);
            wwqUserShareAmountMapper.insert(amount);
        }else if(list.size() == 1){
            WwqUserShareAmount amount = list.get(0);
            amount.setWithdrawalAmount(amount.getWithdrawalAmount().add(shareAmount));
            amount.setTotalShareAmount(amount.getWithdrawalAmount().add(shareAmount));
            amount.setUpdateDate(new Date());
            amount.setUpdateUser(userId);
            wwqUserShareAmountMapper.updateById(amount);
        }else {
            return false;
        }
        //插入分销明细
        WwqUserShareAmountDetail wwqUserShareAmountDetail = new WwqUserShareAmountDetail();
        wwqUserShareAmountDetail.setAmount(shareAmount);
        wwqUserShareAmountDetail.setCreateDate(new Date());
        wwqUserShareAmountDetail.setCreateUser(userId);
        wwqUserShareAmountDetail.setDeleteFlag(0);
        wwqUserShareAmountDetail.setStatus(200);
        wwqUserShareAmountDetail.setType(1);
        wwqUserShareAmountDetail.setUpdateDate(new Date());
        wwqUserShareAmountDetail.setUpdateUser(userId);
        wwqUserShareAmountDetail.setUserId(userId);
        wwqUserShareAmountDetailMapper.insert(wwqUserShareAmountDetail);
        return true;
    }

    /**
     *
     *@Description: 构建支付参数
     *@author yangzhou
     *@date 2016年12月22日 下午11:03:56
     *@return_type Map<String,Object>
     *@param body
     *@param orderId
     *@param totalFee
     *@param spbill_create_ip
     *@param openid
     *@return
     *@throws UnsupportedEncodingException
     */
    public Map<String, Object> postOrder(String body, String orderId,
                                         String totalFee, String spbill_create_ip,String openid)
            throws UnsupportedEncodingException {
        String signType = "MD5";
        BigDecimal fee = new BigDecimal(totalFee).multiply(new BigDecimal(100));
        int fee1 = fee.intValue();
        String appid = IWxPayConfig.WX_WXPUBLIC_APPID;
        String mch_id = IWxPayConfig.WX_WXPUBLIC_MATCH_ID;
        String nonce_str = this.getNonceStr();
        String notify_url = IWxPayConfig.WX_WXPUBLIC_NOTITY_URL;
        String trade_type = IWxPayConfig.WX_WXPUBLIC_TRADE_TYPE;
        SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mch_id);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("out_trade_no", orderId);
        packageParams.put("total_fee", String.valueOf(fee1));
        packageParams.put("spbill_create_ip", spbill_create_ip);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        packageParams.put("openid", openid);
        RequestHandler reqHandler = new RequestHandler();
        String sign = reqHandler.publicCreateSign(packageParams);
        packageParams.put("sign", sign);
        packageParams.put("body", body);
        String xml = WechatXMLConfig.getXMLByMap(packageParams);
        String prepay_id=null;
        System.out.println("xml:"+xml);
        prepay_id = GetWxOrderno.getPayNo(xml);
        System.out.println("result:"+prepay_id);
        SortedMap<String, Object> finalpackage = new TreeMap<String, Object>();
        String timestamp = Sha1Util.getTimeStamp();
        String packages = "prepay_id=" + prepay_id;
        finalpackage.put("appId", appid);
        finalpackage.put("timeStamp", timestamp);
        finalpackage.put("nonceStr", nonce_str);
        finalpackage.put("package", packages);
        finalpackage.put("signType", "MD5");
        String finalsign = reqHandler.publicCreateSign(finalpackage);
        Map<String, Object> payPackage = new HashMap<String, Object>();
        payPackage.put("appId", appid);
        payPackage.put("timeStamp", timestamp);
        payPackage.put("nonceStr", nonce_str);
        payPackage.put("package", packages);
        payPackage.put("signType", signType);
        payPackage.put("paySign", finalsign);
        payPackage.put("paymentId", orderId);
        return payPackage;
    }



    public static String getNonceStr()
    {
        String str = String.valueOf(new Random().nextLong());
        return str.substring(str.length() - 10);
    }
}
