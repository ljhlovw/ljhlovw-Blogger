package com.jingdianjichi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.entity.BloggerUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (BloggerUser)表数据库访问层
 * 
 * @author makejava
 * @since 2024-07-17 20:16:49
 */
@Mapper
public interface BloggerUserDao extends BaseMapper<BloggerUserEntity> {

}

