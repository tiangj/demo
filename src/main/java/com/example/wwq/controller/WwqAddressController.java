package com.example.wwq.controller;


import com.example.wwq.kit.JSONResult;
import com.example.wwq.service.IWwqAddressService;
import com.example.wwq.service.IWwqOrderService;
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
 * 用户收货地址表 前端控制器
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Controller
@RequestMapping("/wwqAddress")
public class WwqAddressController {


    @Autowired
    private IWwqAddressService wwqAddressService;

    @RequestMapping("/addUserAddress")
    @ResponseBody
    public String addUserAddress(
            HttpServletRequest req,
            @RequestParam(value = "phone", required = true) String phone,
            @RequestParam(value = "concatName", required = true) String concatName,
            @RequestParam(value = "code", required = true) String code,
            @RequestParam(value = "province", required = true) String province,
            @RequestParam(value = "city", required = true) String city,
            @RequestParam(value = "county", required = true) String county,
            @RequestParam(value = "detailAddress", required = true) String detailAddress,
            @RequestParam(value = "defaultAddress", required = true) Integer defaultAddress) {
            String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if (userId == null) {
//            return JSONResult.init(301, "success", "user not login");
//        }
        boolean b = wwqAddressService.addUserAddress(userId, phone,
                concatName, code, province, city, county, detailAddress,
                defaultAddress);
        if (b) {
            return JSONResult.init(200, "success", b);
        } else {
            return JSONResult.init(500, "false", b);
        }
    }


    /**
     * 根据用户id获取当前用户地址
     *
     * @return
     */
    @RequestMapping(value = "/shopAddressList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String shopAddressList(
            HttpServletRequest req,
            @RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize) {
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if (userId == null) {
//            return JSONResult.init(301, "success", "user not login");
//        }
        Map<String, Object> page = wwqAddressService.selectListColumnsByInterface(userId, pageNum, pageSize);
        return JSONResult.init(200, "success", page);
    }

    /**
     * 获取省市区的列表
     * @param id 记录的父级ID
     * @return
     */
    @RequestMapping(value = "/getCityCodeList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCityCodeList(
            HttpServletRequest req,
            @RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = true) Integer pageSize) {
        String userId = "1";
//        String userId = authorHelper.getUserId(req);
//        if (userId == null) {
//            return JSONResult.init(301, "success", "user not login");
//        }
        PageInfo<Map<String, Object>> pageCityCode = wwqAddressService.getCityCodeList(id, pageNum, pageSize);
        return JSONResult.init(200, "success", pageCityCode);
    }


    /**
     * 修改默认收货地址
     * @param addressId 地址列表
     * @param defaultAddress 设置为默认的收货地址（传1）
     * @return
     */
    @RequestMapping(value = "/updateDefaultAddress", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateDefaultAddress(
            @RequestParam(value = "addressId", required = true) String addressId,
            @RequestParam(value = "defaultAddress", required = true) Integer defaultAddress) {
        boolean b = wwqAddressService.updateDefaultAddress(addressId,defaultAddress);
        if (b) {
            return JSONResult.init(200, "success", b);
        } else {
            return JSONResult.init(500, "false", b);
        }
    }

    /**
     * 删除收货地址
     * @param addressId 地址列表
     * @return
     */
    @RequestMapping(value = "/deleteUserAddress", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteUserAddress(@RequestParam(value = "addressId", required = true) String addressId){
        boolean b = wwqAddressService.deleteUserAddress(addressId);
        if (b) {
            return JSONResult.init(200, "success", b);
        } else {
            return JSONResult.init(500, "false", b);
        }
    }

}

