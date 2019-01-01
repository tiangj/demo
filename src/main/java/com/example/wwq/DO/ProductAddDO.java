package com.example.wwq.DO;

import com.example.wwq.entity.WwqProduct;

public class ProductAddDO extends WwqProduct {

    private String detailId;

    private Integer postWayId;

    private Integer deliveryAreaId;

    private String detailRemark;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public Integer getPostWayId() {
        return postWayId;
    }

    public void setPostWayId(Integer postWayId) {
        this.postWayId = postWayId;
    }

    public Integer getDeliveryAreaId() {
        return deliveryAreaId;
    }

    public void setDeliveryAreaId(Integer deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }

    public String getDetailRemark() {
        return detailRemark;
    }

    public void setDetailRemark(String detailRemark) {
        this.detailRemark = detailRemark;
    }
}
