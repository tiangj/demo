package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品分类表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_sort")
public class WwqSort extends Model<WwqSort> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 分类的父类
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 商品分类名称
     */
    private String name;
    /**
     * 品牌简介
     */
    private String introduction;
    /**
     * 品牌logo
     */
    private String logo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建日期
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 更新日期
     */
    @TableField("update_date")
    private Date updateDate;
    /**
     * 更新人
     */
    @TableField("update_user")
    private String updateUser;
    /**
     * 是否删除
     */
    private Integer deleteFlag;
    /**
     * 是否展示在首页（0：展示；1：不展示）
     */
    private Integer sort;
    @TableField("parent_ids")
    private String parentIds;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String INTRODUCTION = "introduction";

    public static final String LOGO = "logo";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_USER = "update_user";

    public static final String DELETEFLAG = "deleteFlag";

    public static final String SORT = "sort";

    public static final String PARENT_IDS = "parent_ids";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqSort{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", name=" + name +
        ", introduction=" + introduction +
        ", logo=" + logo +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        ", sort=" + sort +
        ", parentIds=" + parentIds +
        "}";
    }
}
