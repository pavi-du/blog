package com.pavi.blog.web;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Blog;
import com.pavi.blog.po.Tag;
import com.pavi.blog.po.Type;
import com.pavi.blog.po.User;
import com.pavi.blog.service.BlogService;
import com.pavi.blog.service.TagService;
import com.pavi.blog.service.TypeService;
import com.pavi.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/4 20:58
 */
@Controller
public class IndexController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;


    @GetMapping("/")
    public String toIndexPage(@RequestParam(name = "pageNum",defaultValue = "1",required = false)
                              Integer pageNum, Model model, HttpSession session){

        List<Type> types = typeService.listTypeTop(7);
        List<Tag> tags = tagService.listTagWithBlogTop(10);
        //User user = (User)session.getAttribute("user");
        PageInfo<Blog> blogPageInfo = blogService.listBlogByBlogWithTypeWithUser(pageNum, 5,null);

        //List<Blog> blogList = blogPageInfo.getList();
        //
        //blogPageInfo.setList(blogList);

        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("blogPageInfo",blogPageInfo);
        System.out.println(blogPageInfo);
        return "index";
    }

    @ResponseBody
    @GetMapping("/blogs/latest/{count}")
    public Result listLatestBlog(@PathVariable(name = "count")Integer count){

        List<Blog> newBlogList = blogService.listLatestBlog(count);
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        map.put("newBlogList",newBlogList);
        result.setSuccess(true).setData(map);
        return result;
    }

    //@GetMapping("/blog")
    //public String index(){
    //
    //    System.out.println("index");
    //    return "blog";
    //}
    //recommendLatest
    @ResponseBody
    @GetMapping("/blogs/recommendLatest/{blogCount}")
    public Result listBlogRecommendLatest(@PathVariable(name = "blogCount")Integer blogCount){

        List<Blog>  blogListRecommendLatest = blogService.listBlogRecommendLatest(blogCount);
        Map<String,Object> map = new HashMap<>();
        map.put("blogListRecommendLatest",blogListRecommendLatest);
        Result result = new Result();
        result.setSuccess(true).setData(map);
        return result;
    }


    @GetMapping("/blog/{id}")
    public String toBlogDetail(@PathVariable(name = "id")Long id,Model model){

        Blog blog = blogService.getBlogByIdWithConvert(id);
        model.addAttribute("blog",blog);

        return "blog";
    }



    @GetMapping("/search/{pageNum}/{pageSize}")
    public String listBlogBySearchContent(@RequestParam(name = "search",required = false,defaultValue = "")String searchContent,
                                          @PathVariable(name = "pageNum")Integer pageNum,
                                          @PathVariable(name = "pageSize")Integer pageSize,
                                          Model model){

        PageInfo<Blog> blogPageInfo = blogService.listBlogBySearchContentWithTagWithTypeWithUser(searchContent,pageNum,pageSize);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "search";
    }


}
