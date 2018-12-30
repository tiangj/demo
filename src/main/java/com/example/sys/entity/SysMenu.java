package com.example.sys.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-27
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父级ID
     */
    @TableField("parent_id")
    private String parentId;
    /**
     * 父级ids
     */
    @TableField("parent_ids")
    private String parentIds;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 排序
     */
    private BigDecimal sort;
    /**
     * 链接
     */
    private String href;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否显示 1:是,0:否
     */
    @TableField("is_show")
    private String isShow;
    @TableField("create_by")
    private String createBy;
    @TableField("create_date")
    private Date createDate;
    @TableField("update_by")
    private String updateBy;
    @TableField("update_date")
    private Date updateDate;
    private String remarks;
    @TableField("del_flag")
    private String delFlag;
    private String alias;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public static final String ID = "id";

    public static final String PARENT_ID = "parent_id";

    public static final String PARENT_IDS = "parent_ids";

    public static final String NAME = "name";

    public static final String SORT = "sort";

    public static final String HREF = "href";

    public static final String ICON = "icon";

    public static final String IS_SHOW = "is_show";

    public static final String CREATE_BY = "create_by";

    public static final String CREATE_DATE = "create_date";

    public static final String UPDATE_BY = "update_by";

    public static final String UPDATE_DATE = "update_date";

    public static final String REMARKS = "remarks";

    public static final String DEL_FLAG = "del_flag";

    public static final String ALIAS = "alias";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", parentIds=" + parentIds +
        ", name=" + name +
        ", sort=" + sort +
        ", href=" + href +
        ", icon=" + icon +
        ", isShow=" + isShow +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", remarks=" + remarks +
        ", delFlag=" + delFlag +
        ", alias=" + alias +
        "}";
    }
}
