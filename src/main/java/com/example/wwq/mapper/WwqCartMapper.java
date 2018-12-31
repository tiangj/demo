package com.example.wwq.mapper;

import com.example.wwq.entity.WwqCart;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.wwq.entity.WwqProduct;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 购物车 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqCartMapper extends BaseMapper<WwqCart> {

    List<Map<String,Object>> selectCartByproductIdAndTypeIdUserId(Map<String,Object> map);

    Integer insertShopCartRecord(WwqCart wwqCart);

    Integer updateShopCartRecordById(WwqCart wwqCart);

    List<Map<String,Object>> shopProductCartList(Map<String,Object> map);

    WwqCart selectCartInfoByKey(String id);

    Integer shopCartProductNum(Map<String,Object> map);
}
