package com.example.wwq.entity;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户分享返现统计表
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-12
 */
@TableName("wwq_user_share_amount")
public class WwqUserShareAmount extends Model<WwqUserShareAmount> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 总分享返利金额
     */
    @TableField("total_share_amount")
    private BigDecimal totalShareAmount;
    /**
     * 可提现金额
     */
    @TableField("withdrawal_amount")
    private BigDecimal withdrawalAmount;
    /**
     * 已提现金额
     */
    @TableField("has_withdrawal_amount")
    private BigDecimal hasWithdrawalAmount;
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
     * 是否删除
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

    public BigDecimal getTotalShareAmount() {
        return totalShareAmount;
    }

    public void setTotalShareAmount(BigDecimal totalShareAmount) {
        this.totalShareAmount = totalShareAmount;
    }

    public BigDecimal getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public BigDecimal getHasWithdrawalAmount() {
        return hasWithdrawalAmount;
    }

    public void setHasWithdrawalAmount(BigDecimal hasWithdrawalAmount) {
        this.hasWithdrawalAmount = hasWithdrawalAmount;
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

    public static final String TOTAL_SHARE_AMOUNT = "total_share_amount";

    public static final String WITHDRAWAL_AMOUNT = "withdrawal_amount";

    public static final String HAS_WITHDRAWAL_AMOUNT = "has_withdrawal_amount";

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
        return "WwqUserShareAmount{" +
        "id=" + id +
        ", userId=" + userId +
        ", totalShareAmount=" + totalShareAmount +
        ", withdrawalAmount=" + withdrawalAmount +
        ", hasWithdrawalAmount=" + hasWithdrawalAmount +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
