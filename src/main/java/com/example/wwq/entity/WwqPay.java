package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品支付表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_pay")
public class WwqPay extends Model<WwqPay> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 商品规格id
     */
    @TableField("product_type_id")
    private String productTypeId;
    /**
     * 商品id
     */
    @TableField("product_id")
    private String productId;
    /**
     * 商品id
     */
    @TableField("pay_name")
    private String payName;
    /**
     * 商品规格id
     */
    @TableField("total_price")
    private String totalPrice;
    /**
     * 支付状态（100：未支付；200：已支付）
     */
    @TableField("pay_status")
    private Integer payStatus;
    /**
     * 备注
     */
    private String remark;
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
    private Integer deleteFlag;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static final String ID = "id";

    public static final String PRODUCT_TYPE_ID = "product_type_id";

    public static final String PRODUCT_ID = "product_id";

    public static final String PAY_NAME = "pay_name";

    public static final String TOTAL_PRICE = "total_price";

    public static final String PAY_STATUS = "pay_status";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_USER = "update_user";

    public static final String DELETEFLAG = "deleteFlag";

    public static final String USER_ID = "user_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqPay{" +
        "id=" + id +
        ", productTypeId=" + productTypeId +
        ", productId=" + productId +
        ", payName=" + payName +
        ", totalPrice=" + totalPrice +
        ", payStatus=" + payStatus +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        ", userId=" + userId +
        "}";
    }
}
