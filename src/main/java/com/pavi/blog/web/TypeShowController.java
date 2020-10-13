package com.pavi.blog.web;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Blog;
import com.pavi.blog.po.Type;
import com.pavi.blog.service.BlogService;
import com.pavi.blog.service.TypeService;
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
 * @date 2020-10-12 1:12
 **/

@Controller
public class TypeShowController {


    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{typeId}/{pageNum}/{pageSize}")
        public String listBlogByTypeId(@PathVariable(name = "typeId")Long typeId,
                                       @PathVariable(name = "pageNum")Integer pageNum,
                                       @PathVariable(name = "pageSize")Integer pageSize,
                                       Model model){

        List<Type> typeList = typeService.listType();

        PageInfo<Blog> blogPageInfo = blogService.listBlogByTypeIdWithTypeWithUser(typeId,pageNum,pageSize);
        model.addAttribute("typeList",typeList);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("typeId",typeId);
        return "types";
    }

    @GetMapping("/types/{pageNum}/{pageSize}")
        public String listBlog(@PathVariable(name = "pageNum")Integer pageNum,
                                       @PathVariable(name = "pageSize")Integer pageSize,
                                       Model model){

        List<Type> typeList = typeService.listType();

        PageInfo<Blog> blogPageInfo = blogService.listBlogWithTypeWithUser(pageNum,pageSize);
        model.addAttribute("typeList",typeList);
        model.addAttribute("blogPageInfo",blogPageInfo);

        return "types";
    }
}
