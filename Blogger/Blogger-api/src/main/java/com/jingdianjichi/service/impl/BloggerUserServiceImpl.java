package com.jingdianjichi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jingdianjichi.entity.BloggerUserEntity;
import com.jingdianjichi.entity.UserRoleEntity;
import com.jingdianjichi.mapper.BloggerUserDao;
import com.jingdianjichi.service.BloggerUserService;
import com.jingdianjichi.service.UserRoleService;
import com.jingdianjichi.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * (BloggerUser)表服务实现类
 * 
 * @author makejava
 * @since 2024-07-17 20:16:49
 */
@Service("bloggerUserService")
public class BloggerUserServiceImpl extends ServiceImpl<BloggerUserDao, BloggerUserEntity> implements BloggerUserService {
    @Resource
    private BloggerUserDao bloggerUserDao;
    @Resource
    private UserRoleService userRoleService;
    @Override
    public String login(BloggerUserEntity bloggerUser) {
        QueryWrapper<BloggerUserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",bloggerUser.getUserName());
        BloggerUserEntity bloggerUserEntity = bloggerUserDao.selectOne(queryWrapper);
        QueryWrapper<UserRoleEntity> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("user_id",bloggerUserEntity.getUserId());
        UserRoleEntity one = userRoleService.getOne(queryWrapper1);
        if (bloggerUserEntity==null){
            throw new RuntimeException("您还没有注册");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("userId",bloggerUserEntity.getUserId());
        map.put("role",one.getRole());
        map.put("userName",bloggerUserEntity.getUserName());
        String token = JwtUtil.createToken(map);
        return token;
    }

    @Override
    public boolean register(BloggerUserEntity bloggerUser) {
        QueryWrapper<BloggerUserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",bloggerUser.getUserName());
        BloggerUserEntity bloggerUserEntity = bloggerUserDao.selectOne(queryWrapper);
        if (bloggerUserEntity!=null) {
            throw new RuntimeException("用户名已被注册");
        }
        bloggerUserDao.insert(bloggerUser);
        return true;
    }
}

