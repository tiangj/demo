package com.example.wwq.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 省市区表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_area")
public class WwqArea extends Model<WwqArea> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 层级标识： 1  省份， 2  市， 3  区县
     */
    private Integer level;
    /**
     * 父节点
     */
    @TableField("parent_id")
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String LEVEL = "level";

    public static final String PARENT_ID = "parent_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqArea{" +
        "id=" + id +
        ", name=" + name +
        ", level=" + level +
        ", parentId=" + parentId +
        "}";
    }
}
