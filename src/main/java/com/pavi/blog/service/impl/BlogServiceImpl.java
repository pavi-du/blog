package com.pavi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pavi.blog.mapper.BlogMapper;
import com.pavi.blog.po.*;
import com.pavi.blog.service.*;
import com.pavi.blog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/8 14:05
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    BlogTagService blogTagService;


    @Override
    public Blog getBlogById(Long id) {
        Blog blog = blogMapper.getBlogByIdWithTagWithTypeWithUser(id);

        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //HttpSession session = request.getSession();
        //User user =(User) session.getAttribute("user");
        //blog.setUser(user);
        return blog;
    }

    @Override
    public PageInfo<Blog> listBlogByBlogWithTypeWithUser(Integer pageNum,Integer pageSize, Blog blog) {

        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogMapper.listBlogByBlogWithTypeWithUser(blog);


        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    @Override
    public Long saveBlog(Blog blog) {
        Long blogId = blogMapper.saveBlog(blog);
        return blogId;
    }

    @Override
    public void deleteBlogById(Long id) {
        blogMapper.deleteBlogById(id);
    }

    @Override
    public void updateBlogById(Blog blog) {
        blogMapper.updateBlogById(blog);
        //typeService.updateType(blog.getType());

    }

    @Override
    public Blog getBlogByIdWithConvert(Long id) {

        Blog blog = blogMapper.getBlogByIdWithTagWithTypeWithUser(id);
        String resContent = MarkdownUtils.markdownToHtmlExtensions(blog.getContent());
        blog.setContent(resContent);

        //List<BlogTag> blogTagList = blogTagService.getBlogTagByBlogIdWithTag(blog.getId());
        //List<Tag> tagList = new ArrayList<>();
        //for (BlogTag blogTag : blogTagList) {
        //    Tag tag = blogTag.getTag();
        //    tagList.add(tag);
        //}
        //blog.setTagList(tagList);


        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //HttpSession session = request.getSession();
        //User user = (User) session.getAttribute("user");
        //blog.setUser(user);
        return blog;
    }

    @Override
    public PageInfo<Blog> listBlogByTypeIdWithTypeWithUser(Long typeId,Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        List<Blog> blogList = blogMapper.listBlogByTypeIdWithTypeWithUser(typeId);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    @Override
    public PageInfo<Blog> listBlogWithTypeWithUser(Integer pageNum, Integer pageSize) {


        PageHelper.startPage(pageNum,pageSize);

        List<Blog> blogList = blogMapper.listBlogWithTypeWithUser();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;

    }

    @Override
    public PageInfo<Blog> listBlogByTagIdByPagingWithTypeWithUserWithTag(Long tagId,Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogMapper.listBlogByTagIdByPagingWithTypeWithUserWithTag(tagId);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
        return blogPageInfo;
    }

    @Override
    public PageInfo<Blog> listBlogByPagingWithTypeWithUserWithTag(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogMapper.listBlogByPagingWithTypeWithUserWithTag();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
        return blogPageInfo;

    }

    @Override
    public List<Blog> listLatestBlog(Integer count) {
        PageHelper.startPage(1,count);
        List<Blog> blogList = blogMapper.listLatestBlog();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
        return blogPageInfo.getList();
    }




    @Override
    public PageInfo<Blog> listBlogBySearchContentWithTagWithTypeWithUser(String searchContent, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogMapper.listBlogBySearchContentWithTagWithTypeWithUser(searchContent);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);

        return blogPageInfo;
    }

    @Override
    public List<Blog> listBlogRecommendLatest(Integer blogCount) {

        PageHelper.startPage(1,blogCount);
        List<Blog> tempBlogList = blogMapper.listBlogRecommendLatest();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(tempBlogList);
        return blogPageInfo.getList();
    }
}
