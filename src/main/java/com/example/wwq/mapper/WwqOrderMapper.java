package com.example.wwq.mapper;

import com.example.wwq.entity.WwqOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqOrderMapper extends BaseMapper<WwqOrder> {

    List<Map<String,Object>> shopPayList(Map<String,Object> map);

    List<Map<String,Object>>   shopProductOrderList(Map<String,Object> map);

    List<Map<String,Object>> getStatusNumBystatus(Map<String, Object> example);
}
