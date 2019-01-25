package com.example.wwq.service.impl;

import com.example.wwq.entity.WwqShareUserConcart;
import com.example.wwq.mapper.WwqShareUserConcartMapper;
import com.example.wwq.service.IWwqShareUserConcartService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分销用户关联表 服务实现类
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
@Service
public class WwqShareUserConcartServiceImpl extends ServiceImpl<WwqShareUserConcartMapper, WwqShareUserConcart> implements IWwqShareUserConcartService {

    @Autowired
    private WwqShareUserConcartMapper wwqShareUserConcartMapper;

    @Override
    public Boolean createShareUserConcart(WwqShareUserConcart wwqShareUserConcart) {
        Map<String,Object> map = new HashMap<>();
        map.put("parent_id",wwqShareUserConcart.getParentId());
        map.put("delete_flag",0);
        List<WwqShareUserConcart> list = wwqShareUserConcartMapper.selectByMap(map);
        if(list == null || list.size()<1){
            int ret = wwqShareUserConcartMapper.insert(wwqShareUserConcart);
            if(ret > 0){
                return true;
            }
        }
        return false;
    }
}
