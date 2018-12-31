package com.example.wwq.mapper;

import com.example.wwq.entity.WwqProductFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品文件表 Mapper 接口
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
public interface WwqProductFileMapper extends BaseMapper<WwqProductFile> {


    List<Map<String,Object>> selectProductFileListByProductId(Map<String,Object> example);
}
