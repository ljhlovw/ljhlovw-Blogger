package com.jingdianjichi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserRole)表数据库访问层
 * 
 * @author makejava
 * @since 2024-07-17 22:20:00
 */
@Mapper
public interface UserRoleDao extends BaseMapper<UserRoleEntity> {

}

