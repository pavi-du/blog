package com.pavi.blog.web;

import com.pavi.blog.po.Tag;
import com.pavi.blog.po.Type;
import com.pavi.blog.service.TagService;
import com.pavi.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-12 21:21
 **/
@Controller
public class AboutController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/about")
    public String toAboutPage(Model model){

        List<Type> typeList = typeService.listType();
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);

        return "about";
    }
}
