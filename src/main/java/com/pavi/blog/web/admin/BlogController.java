package com.pavi.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.*;
import com.pavi.blog.service.*;
import com.pavi.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/8 14:41
 */

@RequestMapping("")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogTagService blogTagService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/admin/blog")
    public String toSaveBlogPage(Model model){

        List<Type> typeList = typeService.listType();
        List<Tag> tagList = tagService.listTag();


        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);

        return "admin/blogs-input";
    }

    @ResponseBody
    @GetMapping("/admin/blog/initSave")
    public Result initSave(){
        List<Type> types = typeService.listType();
        List<Tag> tags = tagService.listTag();
        Map<String,Object> map = new HashMap<>();
        map.put("types",types);
        map.put("tags",tags);
        return new Result().setSuccess(true).setData(map);
    }

    @PostMapping("/admin/blog")
    public String saveBlog(Blog blog, HttpSession session){


        if(blog.getId()!=null){
            updateBlog(blog);
        } else {
            User user = (User) session.getAttribute("user");

            blog.setViews(1);
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setUser(user);

            Long blogId = blogService.saveBlog(blog);
            //blog.setId(blogId);

            blogTagService.saveBlogTag(blog);
        }


        return "redirect:/admin/blogs";
    }

    private void updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        Blog tempBlog = blogService.getBlogById(blog.getId());
        blog.setViews(tempBlog.getViews()+1);

        blogService.updateBlogById(blog);
        blogTagService.updateBlogTagByBlogId(blog);

    }



    @ResponseBody
    @DeleteMapping("/admin/blog/{id}")
    public Result deleteBlogById(@PathVariable(name = "id")Long id){

        commentService.deleteCommentByBlogId(id);
        blogTagService.deleteTagByBlogId(id);
        blogService.deleteBlogById(id);

        return new Result().setSuccess(true);
    }

    @GetMapping("/admin/blog/{id}")
    public String toUpdateBlogPage(@PathVariable(name = "id")Long id,Model model){

        Blog blog = blogService.getBlogById(id);

        List<BlogTag> blogTags = blogTagService.getBlogTagByBlogId(id);
        List<Tag> tempTagList = new ArrayList<>();
        String tagIds = "";
        for (BlogTag blogTag : blogTags) {
            tempTagList.add(blogTag.getTag());
            tagIds += blogTag.getTag().getId() +",";
        }
        if(tagIds.length()>=1){
            tagIds = tagIds.substring(0,tagIds.length()-1);
        }
        blog.setTagList(tempTagList);
        blog.setTagIds(tagIds);

        List<Type> typeList = typeService.listType();
        List<Tag> tagList = tagService.listTag();

        model.addAttribute("blog",blog);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        System.out.println(blog);
        return "admin/blogs-input";
    }

    @GetMapping("/admin/blogs")
    public String toBlogsPage(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum, Blog blog, Model model){

        Integer pageSize = 5;
        PageInfo<Blog> blogPageInfo = blogService.listBlogByBlogWithTypeWithUser(pageNum, pageSize,blog);
        model.addAttribute("blogPageInfo",blogPageInfo);
        System.out.println(blogPageInfo);
        return "admin/blogs";
    }


    @PostMapping("/admin/blogs")
    public String listBlogs(@RequestParam(name = "pageNum",required = false,defaultValue = "1")Integer pageNum,Blog blog,Model model){


        Integer pageSize = 5;
        PageInfo<Blog> blogPageInfo = blogService.listBlogByBlogWithTypeWithUser(pageNum,pageSize, blog);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "admin/blogs :: blogPage";
    }

    @GetMapping("/admin/blogs/{pageNum}/{pageSize}")
    public String listBlogs(@PathVariable(name = "pageNum")Integer pageNum,
                            @PathVariable(name = "pageSize")Integer pageSize,
                            Model model){


        PageInfo<Blog> blogPageInfo = blogService.listBlogByBlogWithTypeWithUser(pageNum,pageSize, null);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "admin/blogs";

    }
}
