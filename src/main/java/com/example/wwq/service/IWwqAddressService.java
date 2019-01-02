package com.example.wwq.service;

import com.example.wwq.entity.WwqAddress;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * <p>
 * 用户收货地址表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqAddressService extends IService<WwqAddress> {


    boolean addUserAddress(String userId,String phone,String concatName,String code,String province,String city,String county,String detailAddress,Integer defaultAddress);

    Map<String, Object> selectListColumnsByInterface(String userId, Integer pageNum, Integer pageSize);

    PageInfo<Map<String, Object>> getCityCodeList(String id, Integer pageNum, Integer pageSize);

    boolean updateDefaultAddress(String addressId,Integer defaultAddress);

    boolean deleteUserAddress(String addressId);
}
