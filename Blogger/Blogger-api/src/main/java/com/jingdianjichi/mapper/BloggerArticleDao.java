package com.jingdianjichi.mapper;

import java.util.Date;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.entity.BloggerArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (BloggerArticle)表数据库访问层
 * 
 * @author makejava
 * @since 2024-07-19 09:14:33
 */
@Mapper
public interface BloggerArticleDao extends BaseMapper<BloggerArticleEntity> {

}

