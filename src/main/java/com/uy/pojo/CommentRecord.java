package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName comment_record
 */
@TableName(value ="comment_record")
@Data
public class CommentRecord implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父id
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 文章id
     */
    @TableField(value = "articleId")
    private Long articleId;

    /**
     * 文章原作者
     */
    @TableField(value = "originalAuthor")
    private String originalAuthor;

    /**
     * 评论者id
     */
    @TableField(value = "answererId")
    private Integer answererId;

    /**
     * 被评论者id
     */
    @TableField(value = "respondentId")
    private Integer respondentId;

    /**
     * 评论日期
     */
    @TableField(value = "commentDate")
    private String commentDate;

    /**
     * 评论点赞数
     */
    @TableField(value = "likes")
    private Integer likes;

    /**
     * 评论内容
     */
    @TableField(value = "commentContent")
    private String commentContent;

    /**
     * 
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
        CommentRecord other = (CommentRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getOriginalAuthor() == null ? other.getOriginalAuthor() == null : this.getOriginalAuthor().equals(other.getOriginalAuthor()))
            && (this.getAnswererId() == null ? other.getAnswererId() == null : this.getAnswererId().equals(other.getAnswererId()))
            && (this.getRespondentId() == null ? other.getRespondentId() == null : this.getRespondentId().equals(other.getRespondentId()))
            && (this.getCommentDate() == null ? other.getCommentDate() == null : this.getCommentDate().equals(other.getCommentDate()))
            && (this.getLikes() == null ? other.getLikes() == null : this.getLikes().equals(other.getLikes()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getOriginalAuthor() == null) ? 0 : getOriginalAuthor().hashCode());
        result = prime * result + ((getAnswererId() == null) ? 0 : getAnswererId().hashCode());
        result = prime * result + ((getRespondentId() == null) ? 0 : getRespondentId().hashCode());
        result = prime * result + ((getCommentDate() == null) ? 0 : getCommentDate().hashCode());
        result = prime * result + ((getLikes() == null) ? 0 : getLikes().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
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
        sb.append(", pid=").append(pid);
        sb.append(", articleId=").append(articleId);
        sb.append(", originalAuthor=").append(originalAuthor);
        sb.append(", answererId=").append(answererId);
        sb.append(", respondentId=").append(respondentId);
        sb.append(", commentDate=").append(commentDate);
        sb.append(", likes=").append(likes);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}