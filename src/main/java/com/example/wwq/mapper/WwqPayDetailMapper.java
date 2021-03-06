package com.example.wwq.mapper;

import com.example.wwq.entity.WwqPayDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqPayDetailMapper extends BaseMapper<WwqPayDetail> {


    List<WwqPayDetail> getPayOrderList(String payId);
}
