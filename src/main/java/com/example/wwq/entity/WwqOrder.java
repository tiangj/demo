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
 * 订单表
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-23
 */
@TableName("wwq_order")
public class WwqOrder extends Model<WwqOrder> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 用户表id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 商品表id
     */
    @TableField("product_id")
    private String productId;
    /**
     * 下单商品数
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 订单价格
     */
    @TableField("order_total_price")
    private BigDecimal orderTotalPrice;
    /**
     * 100:快递；200：自提；300：到店消费
     */
    @TableField("post_way_type")
    private Integer postWayType;
    /**
     * 地址id
     */
    @TableField("address_id")
    private String addressId;
    /**
     * 送货时间,shop_post_date表的id
     */
    @TableField("post_date_id")
    private String postDateId;
    /**
     * 买家留言
     */
    private String message;
    /**
     * 订单状态（与详情表同步)(100：未支付；200：已支付；300：门店备货；400：发货；500：评价；600：订单完成)
     */
    @TableField("order_status")
    private Integer orderStatus;
    /**
     * 订单支付状态（100：未支付；200：已支付）
     */
    @TableField("pay_status")
    private Integer payStatus;
    /**
     * 订单支付方式（101：微信扫码支付；102：微信公众号支付；103：微信APP支付；201：线下支付）
     */
    @TableField("pay_way")
    private Integer payWay;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Integer getPostWayType() {
        return postWayType;
    }

    public void setPostWayType(Integer postWayType) {
        this.postWayType = postWayType;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPostDateId() {
        return postDateId;
    }

    public void setPostDateId(String postDateId) {
        this.postDateId = postDateId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
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

    public static final String PRODUCT_ID = "product_id";

    public static final String ORDER_NUM = "order_num";

    public static final String ORDER_TOTAL_PRICE = "order_total_price";

    public static final String POST_WAY_TYPE = "post_way_type";

    public static final String ADDRESS_ID = "address_id";

    public static final String POST_DATE_ID = "post_date_id";

    public static final String MESSAGE = "message";

    public static final String ORDER_STATUS = "order_status";

    public static final String PAY_STATUS = "pay_status";

    public static final String PAY_WAY = "pay_way";

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
        return "WwqOrder{" +
        "id=" + id +
        ", userId=" + userId +
        ", productId=" + productId +
        ", orderNum=" + orderNum +
        ", orderTotalPrice=" + orderTotalPrice +
        ", postWayType=" + postWayType +
        ", addressId=" + addressId +
        ", postDateId=" + postDateId +
        ", message=" + message +
        ", orderStatus=" + orderStatus +
        ", payStatus=" + payStatus +
        ", payWay=" + payWay +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
