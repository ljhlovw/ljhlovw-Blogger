package com.jingdianjichi.service.impl;
import java.util.Date;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingdianjichi.mapper.BloggerArticleDao;
import com.jingdianjichi.entity.BloggerArticleEntity;
import com.jingdianjichi.service.BloggerArticleService;
import org.springframework.stereotype.Service;

/**
 * (BloggerArticle)表服务实现类
 * 
 * @author makejava
 * @since 2024-07-19 09:16:33
 */
@Service("bloggerArticleService")
public class BloggerArticleServiceImpl extends ServiceImpl<BloggerArticleDao, BloggerArticleEntity> implements BloggerArticleService {
}

