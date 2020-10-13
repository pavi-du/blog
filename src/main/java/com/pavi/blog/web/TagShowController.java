package com.pavi.blog.web;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Blog;
import com.pavi.blog.po.Tag;
import com.pavi.blog.service.BlogService;
import com.pavi.blog.service.BlogTagService;
import com.pavi.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-12 15:19
 **/
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}/{pageNum}/{pageSize}")
    public String toTagsPage(@PathVariable(name = "id")Long id,
                             @PathVariable(name = "pageNum")Integer pageNum,
                             @PathVariable(name = "pageSize")Integer pageSize,
                             Model model){
        PageInfo<Tag> tagPageInfo = tagService.listTagByPagingWithBlog(pageNum, pageSize);
        PageInfo<Blog> blogPageInfo = blogService.listBlogByTagIdByPagingWithTypeWithUserWithTag(id,pageNum,pageSize);
        model.addAttribute("tagPageInfo",tagPageInfo);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("tagId",id);

        return "tags";
    }

    @GetMapping("/tags/{pageNum}/{pageSize}")
    public String toTagsPage(@PathVariable(name = "pageNum")Integer pageNum,
                             @PathVariable(name = "pageSize")Integer pageSize,
                             Model model){
        PageInfo<Tag> tagPageInfo = tagService.listTagByPagingWithBlog(pageNum, pageSize);
        PageInfo<Blog> blogPageInfo = blogService.listBlogByPagingWithTypeWithUserWithTag(pageNum,pageSize);
        model.addAttribute("tagPageInfo",tagPageInfo);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "tags";
    }
}
