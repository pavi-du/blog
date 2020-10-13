package com.pavi.blog.service;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Tag;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 11:38
 */
public interface TagService {
    List<Tag> listTag();

    List<Tag> listTagWithBlogTop(int count);

    PageInfo<Tag> listTagByPagingWithBlog(Integer pageNum,Integer pageSize);

    Tag getTagById(Long id);

    Boolean saveTag(Tag tag);

    Boolean updateTagById(Tag tag);

    Boolean deleteTagById(Long id);

    PageInfo<Tag> listTagByPaging(Integer pageNum, Integer pageSize);
}
