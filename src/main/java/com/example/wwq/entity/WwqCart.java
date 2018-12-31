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
 * 购物车
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_cart")
public class WwqCart extends Model<WwqCart> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 商品ID
     */
    @TableField("product_id")
    private String productId;
    /**
     * 用户ID
     */
    @TableField("user_id")
    private String userId;
    /**
     * 购买数量
     */
    @TableField("buy_num")
    private Integer buyNum;
    /**
     * 总金额
     */
    @TableField("total_price")
    private BigDecimal totalPrice;
    /**
     * 商品规格id(shop_product_type表的id)
     */
    @TableField("product_type_id")
    private String productTypeId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
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

    public static final String PRODUCT_ID = "product_id";

    public static final String USER_ID = "user_id";

    public static final String BUY_NUM = "buy_num";

    public static final String TOTAL_PRICE = "total_price";

    public static final String PRODUCT_TYPE_ID = "product_type_id";

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
        return "WwqCart{" +
        "id=" + id +
        ", productId=" + productId +
        ", userId=" + userId +
        ", buyNum=" + buyNum +
        ", totalPrice=" + totalPrice +
        ", productTypeId=" + productTypeId +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
