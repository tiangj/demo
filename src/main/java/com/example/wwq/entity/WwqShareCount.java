package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 分销统计表
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-11
 */
@TableName("wwq_share_count")
public class WwqShareCount extends Model<WwqShareCount> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 用户分销等级（1：泉人；2：泉主；3泉仙）
     */
    @TableField("user_level")
    private Integer userLevel;
    /**
     * 直推人数
     */
    @TableField("first_share_num")
    private Integer firstShareNum;
    /**
     * 间推人数
     */
    @TableField("second_share_num")
    private Integer secondShareNum;
    private String remark;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;
    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;
    /**
     * 更新人
     */
    @TableField("update_user")
    private String updateUser;
    /**
     * 是否删除（0：未删除；1：已删除）
     */
    @TableField("delete_flag")
    private Integer deleteFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getFirstShareNum() {
        return firstShareNum;
    }

    public void setFirstShareNum(Integer firstShareNum) {
        this.firstShareNum = firstShareNum;
    }

    public Integer getSecondShareNum() {
        return secondShareNum;
    }

    public void setSecondShareNum(Integer secondShareNum) {
        this.secondShareNum = secondShareNum;
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

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String USER_LEVEL = "user_level";

    public static final String FIRST_SHARE_NUM = "first_share_num";

    public static final String SECOND_SHARE_NUM = "second_share_num";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_USER = "update_user";

    public static final String DELETE_FLAG = "delete_flag";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqShareCount{" +
        "id=" + id +
        ", userId=" + userId +
        ", userLevel=" + userLevel +
        ", firstShareNum=" + firstShareNum +
        ", secondShareNum=" + secondShareNum +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
