package com.pavi.blog.mapper;

import com.pavi.blog.po.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/8 14:06
 */
@Repository
public interface BlogMapper {




    Long saveBlog(Blog blog);

    void deleteBlogById(Long id);

    Blog getBlogByIdWithTagWithTypeWithUser(Long id);

    void updateBlogById(Blog blog);

    List<Blog> listBlogWithTypeWithUser();

    List<Blog> listBlogByTypeIdWithTypeWithUser(Long typeId);

    List<Blog> listBlogByBlogWithTypeWithUser(Blog blog);


    List<Blog> listBlogByTagIdByPagingWithTypeWithUserWithTag(Long tagId);

    List<Blog> listBlogByPagingWithTypeWithUserWithTag();

    List<Blog> listLatestBlog();

    List<Integer> listBlogOfYear();

    List<Blog> listBlogByYear(Integer year);

    List<Blog> listBlogBySearchContentWithTagWithTypeWithUser(String searchContent);

    List<Blog> listBlogRecommendLatest();
}
