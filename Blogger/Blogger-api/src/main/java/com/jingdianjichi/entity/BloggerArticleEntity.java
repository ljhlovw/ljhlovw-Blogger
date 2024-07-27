package com.jingdianjichi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (BloggerArticle)表实体类
 * 
 * @author makejava
 * @since 2024-07-17 17:29:15
 */

@Data
@TableName("blogger_article")
public class BloggerArticleEntity  implements Serializable {
    private static final long serialVersionUID = 392623992158524262L;

    @JsonProperty("postId")
    private Long postId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("lastModified")
    private Date lastModified;
}
