package com.example.wwq.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author generator-plus123
 * @since 2018-12-29
 */
@TableName("wwq_user_score")
public class WwqUserScore extends Model<WwqUserScore> {

    private static final long serialVersionUID = 1L;

    private String id;
    @TableField("user_id")
    private String userId;
    /**
     * 用户可用积分
     */
    private Integer score;
    /**
     * 用户消费积分
     */
    @TableField("consume_score")
    private Integer consumeScore;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getConsumeScore() {
        return consumeScore;
    }

    public void setConsumeScore(Integer consumeScore) {
        this.consumeScore = consumeScore;
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

    public static final String SCORE = "score";

    public static final String CONSUME_SCORE = "consume_score";

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
        return "WwqUserScore{" +
        "id=" + id +
        ", userId=" + userId +
        ", score=" + score +
        ", consumeScore=" + consumeScore +
        ", remark=" + remark +
        ", createDate=" + createDate +
        ", createUser=" + createUser +
        ", updateDate=" + updateDate +
        ", updateUser=" + updateUser +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
