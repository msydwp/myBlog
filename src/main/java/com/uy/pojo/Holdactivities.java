package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName holdActivities
 */
@TableName(value ="holdActivities")
@ToString
@Data
public class Holdactivities implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 举办人-当前用户
     */
    @TableField(value = "sponsor")
    private String sponsor;

    /**
     * 举办标题
     */
    @TableField(value = "holdTitle")
    private String holdTitle;

    /**
     * 举办时间
     */
    @TableField(value = "holdTime")
    private Date holdTime;

    /**
     * 客人
     */
    @TableField(value = "guest")
    private String guest;

    /**
     * 操作人时间
     */
    @TableField(value = "operationTime")
    private Date operationTime;

    /**
     * 礼金
     */
    @TableField(value = "cashGift")
    private Long cashGift;

    /**
     * 举办类别
     */
    @TableField(value = "holdType")
    private Integer holdType;

    /**
     * 
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 举办地址
     */
    @TableField(value = "holdAddress")
    private String holdAddress;

    /**
     * 
     */
    @TableField(value = "sponsorName")
    private String sponsorName;

    /**
     * 
     */
    @TableField(value = "guestName")
    private String guestName;

    @TableField(value = "holdDescribe")
    private String holdDescribe;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private String token ;


}