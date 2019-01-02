package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqAddress;
import com.example.wwq.mapper.WwqAddressMapper;
import com.example.wwq.service.IWwqAddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户收货地址表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqAddressServiceImpl extends ServiceImpl<WwqAddressMapper, WwqAddress> implements IWwqAddressService {

    @Autowired
    private WwqAddressMapper wwqAddressMapper;
    @Override
    public boolean addUserAddress(String userId, String phone,
                                  String concatName, String code, String province, String city,
                                  String county, String detailAddress,Integer defaultAddress) {
        WwqAddress shopAddress = new WwqAddress();
        String address = province.concat(city).concat(county).concat(detailAddress);
        shopAddress.setAddress(address);
        shopAddress.setPhone(phone);
        shopAddress.setProvince(province);
        shopAddress.setCity(city);
        shopAddress.setCode(code);
        shopAddress.setConcatName(concatName);
        shopAddress.setCounty(county);
        shopAddress.setCreateDate(new Date());
        shopAddress.setCreateUser(userId);
        shopAddress.setUpdateDate(new Date());
        shopAddress.setUpdateUser(userId);
        shopAddress.setUserId(userId);
        shopAddress.setDefaultAddress(defaultAddress);
        shopAddress.setDetailAddress(detailAddress);
        shopAddress.setDeleteFlag(0);
        int ret = wwqAddressMapper.insert(shopAddress);
        if(ret > 0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Map<String, Object> selectListColumnsByInterface(String userId,Integer pageNum, Integer pageSize) {
        Map<String, Object> retMap = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> example = new HashMap<>();
        example.put("userId", userId);
        List<Map<String, Object>> shopAddressList = wwqAddressMapper.getUserAddressList1(example);
        PageInfo<Map<String,Object>> pageAddress = new PageInfo<>(shopAddressList);
        retMap.put("pageAddress", pageAddress);
        retMap.put("num", shopAddressList.size());
        return retMap;
    }

    @Override
    public PageInfo<Map<String, Object>> getCityCodeList(String id,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> example = new HashMap<>();
        example.put("id", id);
        List<Map<String, Object>> cityCodeList = wwqAddressMapper.getCityCodeList(example);
        PageInfo<Map<String,Object>> pageAddress = new PageInfo<Map<String,Object>>(cityCodeList);
        return pageAddress;
    }


    @Override
    public boolean updateDefaultAddress(String addressId, Integer defaultAddress) {
        WwqAddress wwqAddress = wwqAddressMapper.getDefaultAddress();
        if(wwqAddress != null){
            WwqAddress shopAddress1 = new WwqAddress();
            shopAddress1.setId(wwqAddress.getId());
            shopAddress1.setDefaultAddress(0);
            int ret1 = wwqAddressMapper.updateById(shopAddress1);
            if(ret1 < 0){
                return false;
            }
        }
        WwqAddress shopAddress = new WwqAddress();
        shopAddress.setId(addressId);
        shopAddress.setDefaultAddress(defaultAddress);
        int ret = wwqAddressMapper.updateById(shopAddress);
        if(ret > 0){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean deleteUserAddress(String addressId) {
        WwqAddress shopAddress1 = wwqAddressMapper.selectById(addressId);
        if(shopAddress1 == null){
            return false;
        }
        WwqAddress shopAddress = new WwqAddress();
        shopAddress.setId(addressId);
        shopAddress.setDeleteFlag(1);
        int ret = wwqAddressMapper.updateById(shopAddress);
        if(ret > 0){
            return true;
        }else{
            return false;
        }
    }
}
