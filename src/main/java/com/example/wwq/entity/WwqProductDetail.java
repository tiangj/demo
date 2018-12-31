package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品详情表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_product_detail")
public class WwqProductDetail extends Model<WwqProductDetail> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * shop_product表的id
     */
    @TableField("shop_product_id")
    private String shopProductId;
    /**
     * 当前商品支持的优惠方式wwq_post_way表的id
     */
    @TableField("post_way_id")
    private String postWayId;
    /**
     * 当前商品支持的配送范围,配送表的id
     */
    @TableField("delivery_area_id")
    private String deliveryAreaId;
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
    @TableField("updata_user")
    private String updataUser;
    /**
     * 是否删除
     */
    private Integer deleteFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopProductId() {
        return shopProductId;
    }

    public void setShopProductId(String shopProductId) {
        this.shopProductId = shopProductId;
    }

    public String getPostWayId() {
        return postWayId;
    }

    public void setPostWayId(String postWayId) {
        this.postWayId = postWayId;
    }

    public String getDeliveryAreaId() {
        return deliveryAreaId;
    }

    public void setDeliveryAreaId(String deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
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

    public String getUpdataUser() {
        return updataUser;
    }

    public void setUpdataUser(String updataUser) {
        this.updataUser = updataUser;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public static final String ID = "id";

    public static final String SHOP_PRODUCT_ID = "shop_product_id";

    public static final String POST_WAY_ID = "post_way_id";

    public static final String DELIVERY_AREA_ID = "delivery_area_id";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATA_USER = "updata_user";

    public static final String DELETEFLAG = "deleteFlag";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqProductDetail{" +
        "id=" + id +
        ", shopProductId=" + shopProductId +
        ", postWayId=" + postWayId +
        ", deliveryAreaId=" + deliveryAreaId +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updataUser=" + updataUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
