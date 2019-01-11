package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqIntegral;
import com.example.wwq.mapper.WwqIntegralMapper;
import com.example.wwq.service.IWwqIntegralService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 积分表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@Service
public class WwqIntegralServiceImpl extends ServiceImpl<WwqIntegralMapper, WwqIntegral> implements IWwqIntegralService {

    @Autowired
    private WwqIntegralMapper wwqIntegralMapper;

    @Override
    public List<WwqIntegral> getUserIntegralList(String userId) {
        WwqIntegral wwqIntegral = new WwqIntegral();
        wwqIntegral.setUserId(userId);
        List<WwqIntegral> wwqIntegral1 = wwqIntegralMapper.getUserIntegralList(userId);
        return wwqIntegral1;
    }
}
