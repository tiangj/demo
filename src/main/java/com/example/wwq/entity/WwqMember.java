package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 会员表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_member")
public class WwqMember extends Model<WwqMember> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 会员等级
     */
    private Integer level;
    /**
     * 会员等级名称
     */
    @TableField("level_name")
    private String levelName;
    /**
     * 会员权益
     */
    @TableField("member_power")
    private String memberPower;
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
    @TableField("is_del")
    private Integer isDel;


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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getMemberPower() {
        return memberPower;
    }

    public void setMemberPower(String memberPower) {
        this.memberPower = memberPower;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String LEVEL = "level";

    public static final String LEVEL_NAME = "level_name";

    public static final String MEMBER_POWER = "member_power";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_USER = "update_user";

    public static final String IS_DEL = "is_del";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqMember{" +
        "id=" + id +
        ", userId=" + userId +
        ", level=" + level +
        ", levelName=" + levelName +
        ", memberPower=" + memberPower +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", isDel=" + isDel +
        "}";
    }
}
