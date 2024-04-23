package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 存储汉字释义的表
 * @TableName definitions
 */
@TableName(value ="definitions")
@Data
public class Definitions implements Serializable {
    /**
     * 释义ID
     */
    @TableId(value = "def_id")
    private Integer def_id;

    /**
     * 字ID
     */
    @TableField(value = "char_id")
    private Integer char_id;

    /**
     * 释义内容
     */
    @TableField(value = "definition")
    private String definition;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Definitions other = (Definitions) that;
        return (this.getDef_id() == null ? other.getDef_id() == null : this.getDef_id().equals(other.getDef_id()))
            && (this.getChar_id() == null ? other.getChar_id() == null : this.getChar_id().equals(other.getChar_id()))
            && (this.getDefinition() == null ? other.getDefinition() == null : this.getDefinition().equals(other.getDefinition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDef_id() == null) ? 0 : getDef_id().hashCode());
        result = prime * result + ((getChar_id() == null) ? 0 : getChar_id().hashCode());
        result = prime * result + ((getDefinition() == null) ? 0 : getDefinition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", def_id=").append(def_id);
        sb.append(", char_id=").append(char_id);
        sb.append(", definition=").append(definition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}