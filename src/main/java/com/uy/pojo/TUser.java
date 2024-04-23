package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class TUser implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    @TableField(value = "userAccount")
    private String userAccount;

    /**
     * 用户名称
     */
    @TableField(value = "userName")
    private String userName;

    /**
     * 用户密码
     */
    @TableField(value = "passWord")
    private String passWord;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 出生日期
     */
    @TableField(value = "birthday")
    private String birthday;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 个人简介
     */
    @TableField(value = "personalBrief")
    private String personalBrief;

    /**
     * 头像url
     */
    @TableField(value = "avatarImgUrl")
    private String avatarImgUrl;

    /**
     * 最近登陆时间
     */
    @TableField(value = "recentlyLanded")
    private String recentlyLanded;

    /**
     * token验证
     */
    @TableField(value = "token")
    private String token;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户状态
     */
    @TableField(value = "status")
    private Long status;

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
        TUser other = (TUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassWord() == null ? other.getPassWord() == null : this.getPassWord().equals(other.getPassWord()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPersonalBrief() == null ? other.getPersonalBrief() == null : this.getPersonalBrief().equals(other.getPersonalBrief()))
            && (this.getAvatarImgUrl() == null ? other.getAvatarImgUrl() == null : this.getAvatarImgUrl().equals(other.getAvatarImgUrl()))
            && (this.getRecentlyLanded() == null ? other.getRecentlyLanded() == null : this.getRecentlyLanded().equals(other.getRecentlyLanded()))
            && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassWord() == null) ? 0 : getPassWord().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPersonalBrief() == null) ? 0 : getPersonalBrief().hashCode());
        result = prime * result + ((getAvatarImgUrl() == null) ? 0 : getAvatarImgUrl().hashCode());
        result = prime * result + ((getRecentlyLanded() == null) ? 0 : getRecentlyLanded().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userName=").append(userName);
        sb.append(", passWord=").append(passWord);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", email=").append(email);
        sb.append(", personalBrief=").append(personalBrief);
        sb.append(", avatarImgUrl=").append(avatarImgUrl);
        sb.append(", recentlyLanded=").append(recentlyLanded);
        sb.append(", token=").append(token);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}