package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqProductComment;
import com.example.wwq.mapper.WwqProductCommentMapper;
import com.example.wwq.service.IWwqProductCommentService;
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
 * 商品评论表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqProductCommentServiceImpl extends ServiceImpl<WwqProductCommentMapper, WwqProductComment> implements IWwqProductCommentService {

    @Autowired
    private WwqProductCommentMapper wwqProductCommentMapper;

    @Override
    public PageInfo<Map<String,Object>> shopProductCommentList(String id, Integer praise, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> example = new HashMap<>();
        example.put("id", id);
        example.put("praise", praise);
        List<Map<String,Object>> list = wwqProductCommentMapper.shopProductCommentList(example);
        PageInfo<Map<String,Object>> pageShopProductCommnet = new PageInfo<>(list);
        return pageShopProductCommnet;
    }


    public Map<String, Object> getShopProductCommentNum(String id){
        Map<String, Object> retMap = new HashMap<>();
        //查询好评的数量
        Map<String, Object> example = new HashMap<>();
        example.put("id", id);
        example.put("praise", 3);
        List<Map<String,Object>> list = wwqProductCommentMapper.shopProductGoodCommentNum(example);
        if(list == null || list.size() < 1){
            retMap.put("badReview", 0);
        }else{
            retMap.put("badReview", list.get(0).get("num"));
        }
        //查询差评的数量
        Map<String, Object> example1 = new HashMap<>();
        example1.put("id", id);
        example1.put("praise", 2);
        List<Map<String,Object>> list1 = wwqProductCommentMapper.shopProductGoodCommentNum(example1);
        if(list1 == null || list1.size() < 1){
            retMap.put("averageReview", 0);
        }else{
            retMap.put("averageReview", list1.get(0).get("num"));
        }
        //查询中评的数量
        Map<String, Object> example2 = new HashMap<>();
        example2.put("id", id);
        example2.put("praise", 1);
        List<Map<String,Object>> list2 = wwqProductCommentMapper.shopProductGoodCommentNum(example2);
        if(list2 == null || list2.size() < 1){
            retMap.put("goodReview", 0);
        }else{
            retMap.put("goodReview", list2.get(0).get("num"));
        }
        return retMap;
    }


    @Override
    public int addShopProductComment(String productId, String userId, String content,Integer praise) {
        WwqProductComment shopProductComment = new WwqProductComment();
        shopProductComment.setContent(content);
        shopProductComment.setProductId(productId);
        shopProductComment.setPraise(praise);
        shopProductComment.setUserId(userId);
        shopProductComment.setCreateDate(new Date());
        shopProductComment.setCreateUser(userId);
        shopProductComment.setUpdateDate(new Date());
        shopProductComment.setUpdateUser(userId);
        shopProductComment.setDeleteFlag(0);
        wwqProductCommentMapper.addShopProductComment(shopProductComment);
        return 1;
    }
}
