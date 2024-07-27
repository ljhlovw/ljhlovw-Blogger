package com.jingdianjichi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jingdianjichi.entity.UserRoleEntity;
import com.jingdianjichi.mapper.UserRoleDao;
import com.jingdianjichi.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * (UserRole)表服务实现类
 * 
 * @author makejava
 * @since 2024-07-17 22:20:00
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {
}

