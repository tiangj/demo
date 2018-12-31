package com.example.wwq.mapper;

import com.example.wwq.entity.WwqMember;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqMemberMapper extends BaseMapper<WwqMember> {


    WwqMember selectProductInfoByUserKey(String userId);


}
