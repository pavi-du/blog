package com.pavi.blog.service;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Blog;

import java.util.List;

public interface BlogService {



    /*
     * 根据博客ID查询博客
     *
     * @author pavi
     * @param id
     * @return
     * @date 2020/10/11 1:27
     */
    Blog getBlogById(Long id);

    PageInfo<Blog>  listBlogByBlogWithTypeWithUser(Integer pageNum,Integer pageSize, Blog blog);

    Long saveBlog(Blog blog);

    void deleteBlogById(Long id);

    void updateBlogById(Blog blog);


    /*
     * 获取博客并转为HTML格式
     *
     * @author pavi
     * @param id
     * @return
     * @date 2020/10/11 2:24
     */
    Blog getBlogByIdWithConvert(Long id);



    PageInfo<Blog> listBlogByTypeIdWithTypeWithUser(Long typeId,Integer pageNum,Integer pageSize);



    PageInfo<Blog> listBlogWithTypeWithUser(Integer pageNum, Integer pageSize);


    /**
     * 根据tagId查询博客
     *
     * @author pavi
     * @param tagId
     * @return
     * @date 2020/10/12 16:07
     */
    PageInfo<Blog> listBlogByTagIdByPagingWithTypeWithUserWithTag(Long tagId,Integer pageNum,Integer pageSize);

    PageInfo<Blog> listBlogByPagingWithTypeWithUserWithTag(Integer pageNum, Integer pageSize);

    List<Blog> listLatestBlog(Integer count);

    PageInfo<Blog> listBlogBySearchContentWithTagWithTypeWithUser(String searchContent, Integer pageNum, Integer pageSize);

    List<Blog> listBlogRecommendLatest(Integer blogCount);
}
