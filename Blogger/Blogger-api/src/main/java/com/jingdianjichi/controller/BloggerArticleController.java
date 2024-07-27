package com.jingdianjichi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jingdianjichi.entity.BloggerArticleEntity;
import com.jingdianjichi.entity.R;
import com.jingdianjichi.service.BloggerArticleService;
import com.jingdianjichi.utils.PageUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * (BloggerArticle)表控制层
 * 
 * @author makejava
 * @since 2024-07-17 20:19:13
 */
@RestController
    @RequestMapping("bloggerArticle")
public class BloggerArticleController {
    /**
     * 服务对象
     */
    @Resource
    private BloggerArticleService bloggerArticleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param bloggerArticle 查询实体
     * @return 所有数据
     */
  /*  @GetMapping
    public R selectAll(Page<BloggerArticleEntity> page, BloggerArticleEntity bloggerArticle) {
        return R.ok(this.bloggerArticleService.page(page, new QueryWrapper<>(bloggerArticle)));
    }*/

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.bloggerArticleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bloggerArticle 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BloggerArticleEntity bloggerArticle) {
        return R.ok(this.bloggerArticleService.save(bloggerArticle));
    }

    /**
     * 修改数据
     *
     * @param bloggerArticle 实体对象
     * @return 修改结果
     */
   @PutMapping
    public R update(@RequestBody BloggerArticleEntity bloggerArticle) {
        return R.ok(this.bloggerArticleService.updateById(bloggerArticle));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.bloggerArticleService.removeByIds(idList));
    }
    @GetMapping("selectAll")
    public R selectAll() {
        return R.ok(bloggerArticleService.list());
    }

    @GetMapping("selectByUserId")
    public R selectByUserId(@RequestParam("id") Long id,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize) {
        QueryWrapper<BloggerArticleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        IPage<BloggerArticleEntity> page = new Page<>(pageNo, pageSize);
        IPage<BloggerArticleEntity> page1 = bloggerArticleService.page(page, queryWrapper);
        PageUtils pageUtils = new PageUtils(page1);
        return R.ok(pageUtils);
    }
}

