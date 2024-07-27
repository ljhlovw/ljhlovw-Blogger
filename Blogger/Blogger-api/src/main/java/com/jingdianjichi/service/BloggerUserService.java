package com.jingdianjichi.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jingdianjichi.entity.BloggerUserEntity;


/**
 * (BloggerUser)表服务接口
 * 
 * @author makejava
 * @since 2024-07-17 20:16:49
 */
public interface BloggerUserService extends IService<BloggerUserEntity> {
    String login(BloggerUserEntity bloggerUser);

    boolean register(BloggerUserEntity bloggerUser);
}

