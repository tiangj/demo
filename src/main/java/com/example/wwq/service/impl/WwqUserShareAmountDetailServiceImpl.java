package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqUserShareAmountDetail;
import com.example.wwq.mapper.WwqUserShareAmountDetailMapper;
import com.example.wwq.service.IWwqUserShareAmountDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户分享返利提现明细表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
@Service
public class WwqUserShareAmountDetailServiceImpl extends ServiceImpl<WwqUserShareAmountDetailMapper, WwqUserShareAmountDetail> implements IWwqUserShareAmountDetailService {

    @Autowired
    private WwqUserShareAmountDetailMapper wwqUserShareAmountDetailMapper;


    public PageInfo<Map<String,Object>> userShareCountAmountDetail(String userId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String,Object>> retList = wwqUserShareAmountDetailMapper.userShareCountAmountDetail(userId);
        PageInfo<Map<String,Object>> pageList = new PageInfo<Map<String,Object>>(retList);
        return pageList;
    }
}
