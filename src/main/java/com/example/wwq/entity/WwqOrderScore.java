package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单积分明细记录表（满500创建22条记录）
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-11
 */
@TableName("wwq_order_score")
public class WwqOrderScore extends Model<WwqOrderScore> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 订单id
     */
    @TableField("order_id")
    private String orderId;
    /**
     * 单次积分数量
     */
    private Integer integral;
    /**
     * 排序（第几周执行这个）
     */
    private Integer sort;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 此积分是否已送出（1：未送出；2已送出）
     */
    @TableField("execute_flag")
    private Integer executeFlag;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getExecuteFlag() {
        return executeFlag;
    }

    public void setExecuteFlag(Integer executeFlag) {
        this.executeFlag = executeFlag;
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

    public static final String ORDER_ID = "order_id";

    public static final String INTEGRAL = "integral";

    public static final String SORT = "sort";

    public static final String USER_ID = "user_id";

    public static final String EXECUTE_FLAG = "execute_flag";

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
        return "WwqOrderScore{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", integral=" + integral +
        ", sort=" + sort +
        ", userId=" + userId +
        ", executeFlag=" + executeFlag +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
