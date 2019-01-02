package com.example.wwq.mapper;

import com.example.wwq.entity.WwqAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户收货地址表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqAddressMapper extends BaseMapper<WwqAddress> {

    List<Map<String, Object>> getUserAddressList1(Map<String,Object> map);

    List<Map<String,Object>> getCityCodeList(Map<String,Object> map);

    WwqAddress getDefaultAddress();
}
