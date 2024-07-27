package com.jingdianjichi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (BloggerUser)表实体类
 * 
 * @author makejava
 * @since 2024-07-17 20:16:49
 */

@Data
@TableName("blogger_user")
public class BloggerUserEntity  implements Serializable {
    private static final long serialVersionUID = -59817471755316673L;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("lastModified")
    private Date lastModified;
}
