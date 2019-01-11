package com.example.wwq.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.example.wwq.entity.WwqExchangeOrder;
import com.example.wwq.entity.WwqIntegral;
import com.example.wwq.entity.WwqScoreMall;
import com.example.wwq.entity.WwqUserScore;
import com.example.wwq.mapper.*;
import com.example.wwq.service.IWwqScoreMallService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 积分兑换商城 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-08
 */
@Service
public class WwqScoreMallServiceImpl extends ServiceImpl<WwqScoreMallMapper, WwqScoreMall> implements IWwqScoreMallService {

    @Autowired
    private WwqScoreMallMapper wwqScoreMallMapper;

    @Autowired
    private WwqUserScoreMapper wwqUserScoreMapper;

    @Autowired
    private WwqIntegralMapper wwqIntegralMapper;

    @Autowired
    private WwqExchangeOrderMapper wwqExchangeOrderMapper;

    @Override
    public PageInfo<Map<String, Object>> getScoreMallProductList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> retList = wwqScoreMallMapper.getScoreMallProductList();
        PageInfo<Map<String, Object>> pageScoreMall = new PageInfo<>(retList);
        return pageScoreMall;
    }

    @Transactional
    @Override
    public boolean exchangeScoreMallProduct(String userId, String id) {
       // try {
            //查询被兑换的商品信息
            WwqScoreMall wwqScoreMall = wwqScoreMallMapper.selectById(id);
            if (wwqScoreMall == null) {
                return false;
            }
            //查询用户的积分
            WwqUserScore wwqUserScore = new WwqUserScore();
            wwqUserScore.setUserId(userId);
            WwqUserScore wwqUserScore1 = wwqUserScoreMapper.selectOne(wwqUserScore);
            if (wwqUserScore1 == null) {
                return false;
            }
            //比较用户的积分与兑换商品需要的积分是否相等
            if (wwqScoreMall.getExchangeScroe() <= wwqUserScore1.getScore()) {
                //可兑换
                //先更新用户积分总计表
                wwqUserScore1.setScore(wwqUserScore1.getScore() - wwqScoreMall.getExchangeScroe());
                wwqUserScore1.setConsumeScore(wwqUserScore1.getConsumeScore() + wwqScoreMall.getExchangeScroe());
                wwqUserScoreMapper.updateById(wwqUserScore1);
                //再更新用户积分明细表
                WwqIntegral wwqIntegral = new WwqIntegral();
                wwqIntegral.setDeleteFlag(0);
                wwqIntegral.setCreateDate(new Date());
                wwqIntegral.setCreateUser(userId);
                wwqIntegral.setIntegralDetail(wwqScoreMall.getExchangeScroe());
                wwqIntegral.setProductId(wwqScoreMall.getProductId());
                wwqIntegral.setUpdateDate(new Date());
                wwqIntegral.setUserId(userId);
                wwqIntegral.setUpdateUser(userId);
                wwqIntegral.setWayType("2");
                wwqIntegralMapper.insert(wwqIntegral);
                //再更新积分兑换记录表
                WwqExchangeOrder wwqExchangeOrder = new WwqExchangeOrder();
                wwqExchangeOrder.setConsumeFlag(2);
                wwqExchangeOrder.setCreateDate(new Date());
                wwqExchangeOrder.setCreateUser(userId);
                wwqExchangeOrder.setDeleteFlag(0);
                wwqExchangeOrder.setIntegralDetail(wwqScoreMall.getExchangeScroe());
                wwqExchangeOrder.setProductId(wwqScoreMall.getProductId());
                wwqExchangeOrder.setUpdateDate(new Date());
                wwqExchangeOrder.setUpdateUser(userId);
                wwqExchangeOrder.setUserId(userId);
                wwqExchangeOrderMapper.insert(wwqExchangeOrder);
                return true;
            } else {
                return false;
            }
//        }catch (Exception e){
//            throw Exception();
//            e.printStackTrace();
//            return false;
//        }
    }
}
