package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 存储汉字信息的表
 * @TableName characters
 */
@TableName(value ="characters")
@Data
public class Characters implements Serializable {
    /**
     * 字ID
     */
    @TableId(value = "char_id")
    private Integer char_id;

    /**
     * 字
     */
    @TableField(value = "char_name")
    private String char_name;

    /**
     * 拼音
     */
    @TableField(value = "pinyin")
    private String pinyin;

    /**
     * 笔画数
     */
    @TableField(value = "stroke_count")
    private Integer stroke_count;

    /**
     * 部首
     */
    @TableField(value = "radicals")
    private String radicals;

    @TableField(value = "data_gif")
    private String dataGif;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}