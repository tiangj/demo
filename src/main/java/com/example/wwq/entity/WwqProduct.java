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
 * 商品主表
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_product")
public class WwqProduct extends Model<WwqProduct> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 商品原价
     */
    @TableField("product_orgin_price")
    private BigDecimal productOrginPrice;
    /**
     * 折扣价
     */
    @TableField("product_now_price")
    private BigDecimal productNowPrice;
    /**
     * 商品销量
     */
    @TableField("product_num")
    private Integer productNum;
    /**
     * 物流费用
     */
    @TableField("post_price")
    private BigDecimal postPrice;
    /**
     * 是否推荐为品牌(0：不推荐，1推荐)
     */
    @TableField("recommend_brand")
    private Integer recommendBrand;
    /**
     * 销售量(废弃)
     */
    @TableField("sell_num")
    private Integer sellNum;
    /**
     * 剩余数量(废弃)
     */
    @TableField("remain_num")
    private Integer remainNum;
    /**
     * 商品描述
     */
    @TableField("product_dec")
    private String productDec;
    /**
     * 商品所属分类id(shop_sort表的id)
     */
    @TableField("sort_id")
    private String sortId;
    /**
     * 配送范围id
     */
    @TableField("scope_id")
    private String scopeId;
    /**
     * 是否显示在首页(0：显示；1：不显示）
     */
    private Integer sort;
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
     * 是否推荐为店选精品（0：是；1：否）
     */
    @TableField("recommend_boutique")
    private Integer recommendBoutique;

    @TableField("product_type")
    private Integer productType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductOrginPrice() {
        return productOrginPrice;
    }

    public void setProductOrginPrice(BigDecimal productOrginPrice) {
        this.productOrginPrice = productOrginPrice;
    }

    public BigDecimal getProductNowPrice() {
        return productNowPrice;
    }

    public void setProductNowPrice(BigDecimal productNowPrice) {
        this.productNowPrice = productNowPrice;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public BigDecimal getPostPrice() {
        return postPrice;
    }

    public void setPostPrice(BigDecimal postPrice) {
        this.postPrice = postPrice;
    }

    public Integer getRecommendBrand() {
        return recommendBrand;
    }

    public void setRecommendBrand(Integer recommendBrand) {
        this.recommendBrand = recommendBrand;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public String getProductDec() {
        return productDec;
    }

    public void setProductDec(String productDec) {
        this.productDec = productDec;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Integer getRecommendBoutique() {
        return recommendBoutique;
    }

    public void setRecommendBoutique(Integer recommendBoutique) {
        this.recommendBoutique = recommendBoutique;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public static final String ID = "id";

    public static final String PRODUCT_NAME = "product_name";

    public static final String PRODUCT_ORGIN_PRICE = "product_orgin_price";

    public static final String PRODUCT_NOW_PRICE = "product_now_price";

    public static final String PRODUCT_NUM = "product_num";

    public static final String POST_PRICE = "post_price";

    public static final String RECOMMEND_BRAND = "recommend_brand";

    public static final String SELL_NUM = "sell_num";

    public static final String REMAIN_NUM = "remain_num";

    public static final String PRODUCT_DEC = "product_dec";

    public static final String SORT_ID = "sort_id";

    public static final String SCOPE_ID = "scope_id";

    public static final String SORT = "sort";

    public static final String REMARK = "remark";

    public static final String CREATE_DATE = "create_date";

    public static final String CREATE_USER = "create_user";

    public static final String UPDATE_DATE = "update_date";

    public static final String UPDATE_USER = "update_user";

    public static final String DELETEFLAG = "deleteFlag";

    public static final String RECOMMEND_BOUTIQUE = "recommend_boutique";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WwqProduct{" +
        "id=" + id +
        ", productName=" + productName +
        ", productOrginPrice=" + productOrginPrice +
        ", productNowPrice=" + productNowPrice +
        ", productNum=" + productNum +
        ", postPrice=" + postPrice +
        ", recommendBrand=" + recommendBrand +
        ", sellNum=" + sellNum +
        ", remainNum=" + remainNum +
        ", productDec=" + productDec +
        ", sortId=" + sortId +
        ", scopeId=" + scopeId +
        ", sort=" + sort +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        ", recommendBoutique=" + recommendBoutique +
        "}";
    }
}
