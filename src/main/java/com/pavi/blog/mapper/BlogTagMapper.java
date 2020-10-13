package com.pavi.blog.mapper;

import com.pavi.blog.po.BlogTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/8 14:06
 */
@Repository
public interface BlogTagMapper {


    void saveTagBlog(@Param("blogId") Long blogId, List<Long> tagIds);

    void deleteTagByBlogId(Long id);

    List<BlogTag> getBlogTagByBlogId(Long id);

    List<BlogTag> getBlogTagByBlogIdWithTag(Long id);
}
