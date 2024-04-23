package com.uy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章id
     */
    @TableField(value = "articleId")
    private Long articleId;

    /**
     * 作者
     */
    @TableField(value = "author")
    private String author;

    /**
     * 文章原作者
     */
    @TableField(value = "originalAuthor")
    private String originalAuthor;

    /**
     * 文章标题
     */
    @TableField(value = "articleTitle")
    private String articleTitle;

    /**
     * 文章内容
     */
    @TableField(value = "articleContent")
    private String articleContent;

    /**
     * 文章标签
     */
    @TableField(value = "articleTags")
    private String articleTags;

    /**
     * 文章类型
     */
    @TableField(value = "articleType")
    private String articleType;

    /**
     * 文章分类
     */
    @TableField(value = "articleCategories")
    private String articleCategories;

    /**
     * 文章发布日期
     */
    @TableField(value = "publishDate")
    private String publishDate;

    /**
     * 更新文章日期
     */
    @TableField(value = "updateDate")
    private String updateDate;

    /**
     * 文章url
     */
    @TableField(value = "articleUrl")
    private String articleUrl;

    /**
     * 文章摘要
     */
    @TableField(value = "articleTabloid")
    private String articleTabloid;

    /**
     * 文章喜欢数
     */
    @TableField(value = "likes")
    private Long likes;

    /**
     * 上一篇文章id
     */
    @TableField(value = "lastArticleId")
    private Long lastArticleId;

    /**
     * 下一篇文章id
     */
    @TableField(value = "nextArticledId")
    private Long nextArticledId;

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
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getOriginalAuthor() == null ? other.getOriginalAuthor() == null : this.getOriginalAuthor().equals(other.getOriginalAuthor()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()))
            && (this.getArticleTags() == null ? other.getArticleTags() == null : this.getArticleTags().equals(other.getArticleTags()))
            && (this.getArticleType() == null ? other.getArticleType() == null : this.getArticleType().equals(other.getArticleType()))
            && (this.getArticleCategories() == null ? other.getArticleCategories() == null : this.getArticleCategories().equals(other.getArticleCategories()))
            && (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getArticleUrl() == null ? other.getArticleUrl() == null : this.getArticleUrl().equals(other.getArticleUrl()))
            && (this.getArticleTabloid() == null ? other.getArticleTabloid() == null : this.getArticleTabloid().equals(other.getArticleTabloid()))
            && (this.getLikes() == null ? other.getLikes() == null : this.getLikes().equals(other.getLikes()))
            && (this.getLastArticleId() == null ? other.getLastArticleId() == null : this.getLastArticleId().equals(other.getLastArticleId()))
            && (this.getNextArticledId() == null ? other.getNextArticledId() == null : this.getNextArticledId().equals(other.getNextArticledId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getOriginalAuthor() == null) ? 0 : getOriginalAuthor().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        result = prime * result + ((getArticleTags() == null) ? 0 : getArticleTags().hashCode());
        result = prime * result + ((getArticleType() == null) ? 0 : getArticleType().hashCode());
        result = prime * result + ((getArticleCategories() == null) ? 0 : getArticleCategories().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getArticleUrl() == null) ? 0 : getArticleUrl().hashCode());
        result = prime * result + ((getArticleTabloid() == null) ? 0 : getArticleTabloid().hashCode());
        result = prime * result + ((getLikes() == null) ? 0 : getLikes().hashCode());
        result = prime * result + ((getLastArticleId() == null) ? 0 : getLastArticleId().hashCode());
        result = prime * result + ((getNextArticledId() == null) ? 0 : getNextArticledId().hashCode());
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
        sb.append(", articleId=").append(articleId);
        sb.append(", author=").append(author);
        sb.append(", originalAuthor=").append(originalAuthor);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", articleTags=").append(articleTags);
        sb.append(", articleType=").append(articleType);
        sb.append(", articleCategories=").append(articleCategories);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", articleUrl=").append(articleUrl);
        sb.append(", articleTabloid=").append(articleTabloid);
        sb.append(", likes=").append(likes);
        sb.append(", lastArticleId=").append(lastArticleId);
        sb.append(", nextArticledId=").append(nextArticledId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}