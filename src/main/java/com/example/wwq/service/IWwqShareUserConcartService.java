package com.example.wwq.service;

import com.example.wwq.entity.WwqShareUserConcart;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 分销用户关联表 服务类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
public interface IWwqShareUserConcartService extends IService<WwqShareUserConcart> {


    Boolean createShareUserConcart(WwqShareUserConcart wwqShareUserConcart);
}
