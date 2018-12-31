package com.example.wwq.service;

import com.example.wwq.entity.WwqProductComment;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品评论表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface IWwqProductCommentService extends IService<WwqProductComment> {

    PageInfo<Map<String,Object>> shopProductCommentList(String id, Integer praise, Integer pageNum, Integer pageSize);

    public Map<String, Object> getShopProductCommentNum(String id);

    public int addShopProductComment(String productId,String userId,String content,Integer praise);
}
