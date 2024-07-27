package com.jingdianjichi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (UserRole)表实体类
 * 
 * @author makejava
 * @since 2024-07-17 22:20:00
 */

@Data
@TableName("user_role")
public class UserRoleEntity  implements Serializable {
    private static final long serialVersionUID = -64263793510577083L;
            
  
    private Long id;
            
  
    private Long userId;
            
  
    private Integer role;
}
