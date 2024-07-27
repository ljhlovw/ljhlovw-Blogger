package com.jingdianjichi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jingdianjichi.entity.BloggerUserEntity;
import com.jingdianjichi.entity.R;
import com.jingdianjichi.service.BloggerUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (BloggerUser)表控制层
 * 
 * @author makejava
 * @since 2024-07-17 20:16:49
 */
@RestController
@RequestMapping("bloggerUser")
public class BloggerUserController {
    /**
     * 服务对象
     */
    @Resource
    private BloggerUserService bloggerUserService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param bloggerUser 查询实体
     * @return 所有数据
     */
    /* @GetMapping
    public R selectAll(Page<BloggerUserEntity> page, BloggerUserEntity bloggerUser) {
        return R.ok(this.bloggerUserService.page(page, new QueryWrapper<>(bloggerUser)));
    }*/

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.ok(this.bloggerUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bloggerUser 实体对象
     * @return 新增结果
     */
    /*   @PostMapping
    public R insert(@RequestBody BloggerUserEntity bloggerUser) {
        return R.ok(this.bloggerUserService.save(bloggerUser));
    }*/

    /**
     * 修改数据
     *
     * @param bloggerUser 实体对象
     * @return 修改结果
     */
    /*@PutMapping
    public R update(@RequestBody BloggerUserEntity bloggerUser) {
        return R.ok(this.bloggerUserService.updateById(bloggerUser));
    }*/

    /**
     * 删除数据
     *
     * @param
     * @return 删除结果
     *//*
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.bloggerUserService.removeByIds(idList));
    }*/
    @PostMapping("login")
    public R<String> login(@RequestBody BloggerUserEntity bloggerUser){
       return R.ok(this.bloggerUserService.login(bloggerUser));
    }
    @PostMapping("register")
    public R register(@RequestBody BloggerUserEntity bloggerUser){
        bloggerUser.setCreated(new Date());
        bloggerUser.setLastModified(new Date());
        return R.ok(this.bloggerUserService.register(bloggerUser));
    }
}

