package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 积分表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_integral")
public class WwqIntegral extends Model<WwqIntegral> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 用户积分进出明细
     */
    @TableField("integral_detail")
    private Integer integralDetail;
    /**
     * 积分进出方式（1:获取；2：消费抵扣）
     */
    @TableField("way_type")
    private String wayType;
    /**
     * 商品id
     */
    @TableField("product_id")
    private String productId;
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

    public Integer getIntegralDetail() {
        return integralDetail;
    }

    public void setIntegralDetail(Integer integralDetail) {
        this.integralDetail = integralDetail;
    }

    public String getWayType() {
        return wayType;
    }

    public void setWayType(String wayType) {
        this.wayType = wayType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public static final String INTEGRAL_DETAIL = "integral_detail";

    public static final String WAY_TYPE = "way_type";

    public static final String PRODUCT_ID = "product_id";

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
        return "WwqIntegral{" +
        "id=" + id +
        ", userId=" + userId +
        ", integralDetail=" + integralDetail +
        ", wayType=" + wayType +
        ", productId=" + productId +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
