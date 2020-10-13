package com.pavi.blog.service;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Blog;
import com.pavi.blog.po.BlogTag;

import java.util.List;

public interface BlogTagService {
    void saveBlogTag(Blog blog);

    void deleteTagByBlogId(Long id);

    List<BlogTag> getBlogTagByBlogId(Long id);

    void updateBlogTagByBlogId(Blog blog);

    List<BlogTag> getBlogTagByBlogIdWithTag(Long id);

    PageInfo<Blog> ListBlogByTagIdByPagingWithTypeWithUserWithTag(Long id);
}
