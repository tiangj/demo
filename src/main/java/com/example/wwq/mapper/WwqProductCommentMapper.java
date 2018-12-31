package com.example.wwq.mapper;

import com.example.wwq.entity.WwqProductComment;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品评论表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqProductCommentMapper extends BaseMapper<WwqProductComment> {

    List<Map<String,Object>> shopProductCommentList(Map<String,Object> example);

    List<Map<String,Object>> shopProductGoodCommentNum(Map<String,Object> example);

    Integer addShopProductComment(WwqProductComment comment);
}
