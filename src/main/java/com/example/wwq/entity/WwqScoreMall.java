package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 积分兑换商城
 * </p>
 *
 * @author generator-plus123
 * @since 2019-01-08
 */
@TableName("wwq_score_mall")
public class WwqScoreMall extends Model<WwqScoreMall> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("product_id")
    private String productId;
    @TableField("remain_num")
    private Integer remainNum;
    @TableField("exchange_scroe")
    private Integer exchangeScroe;
    private String remark;
    @TableField("create_date")
    private Date createDate;
    @TableField("create_user")
    private String createUser;
    @TableField("update_date")
    private Date updateDate;
    @TableField("update_user")
    private String updateUser;
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

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public Integer getExchangeScroe() {
        return exchangeScroe;
    }

    public void setExchangeScroe(Integer exchangeScroe) {
        this.exchangeScroe = exchangeScroe;
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

    public static final String REMAIN_NUM = "remain_num";

    public static final String EXCHANGE_SCROE = "exchange_scroe";

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
        return "WwqScoreMall{" +
        "id=" + id +
        ", productId=" + productId +
        ", remainNum=" + remainNum +
        ", exchangeScroe=" + exchangeScroe +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
