package com.pavi.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.mapper.BlogTagMapper;
import com.pavi.blog.po.Blog;
import com.pavi.blog.po.BlogTag;
import com.pavi.blog.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-09 16:15
 **/
@Service
    public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public void saveBlogTag(Blog blog) {

        //List<Long> tagIds = generateIds(blog.getTagIds());
        List<Long> tagIdList = blog.tagIdsToTagIdList();
        if(tagIdList.size()>0){
            blogTagMapper.saveTagBlog(blog.getId(),tagIdList);
        }

    }

    @Override
    public void deleteTagByBlogId(Long id) {
        blogTagMapper.deleteTagByBlogId(id);
    }



    @Override
    public void updateBlogTagByBlogId(Blog blog) {
        List<Long> tagIdList = blog.tagIdsToTagIdList();
        blogTagMapper.deleteTagByBlogId(blog.getId());
        if(tagIdList.size()>0){
            blogTagMapper.saveTagBlog(blog.getId(),tagIdList);
        }


    }



    private List<Long> generateIds(String tagIdStrArg){

        List<Long> tagIds = new ArrayList<>();

        String[] tagIdArr = tagIdStrArg.split(",");
        for (String tagIdStr : tagIdArr) {
            if(tagIdArr != null && !StringUtils.isEmpty(tagIdStr)){
                Long tagId = Long.parseLong(tagIdStr);
                tagIds.add(tagId);
            }
        }
        return tagIds;
    }


    @Override
    public List<BlogTag> getBlogTagByBlogId(Long id) {

        List<BlogTag> blogTags = blogTagMapper.getBlogTagByBlogId(id);

        return blogTags;
    }

    @Override
    public List<BlogTag> getBlogTagByBlogIdWithTag(Long id) {

        List<BlogTag> blogTagList = blogTagMapper.getBlogTagByBlogIdWithTag(id);

        return blogTagList;
    }

    @Override
    public PageInfo<Blog> ListBlogByTagIdByPagingWithTypeWithUserWithTag(Long id) {


        return null;
    }

}
