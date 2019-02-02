package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqUserShareAmount;
import com.example.wwq.mapper.WwqUserShareAmountMapper;
import com.example.wwq.service.IWwqUserShareAmountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户分享返现统计表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
@Service
public class WwqUserShareAmountServiceImpl extends ServiceImpl<WwqUserShareAmountMapper, WwqUserShareAmount> implements IWwqUserShareAmountService {

    @Autowired
    private WwqUserShareAmountMapper wwqUserShareAmountMapper;

    @Override
    public Map<String, Object> userShareCountAmount(String userId) {
        Map<String,Object> retList = wwqUserShareAmountMapper.userShareCountAmount(userId);
        return retList;
    }
}
