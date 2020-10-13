package com.pavi.blog.web;

import com.pavi.blog.po.Blog;
import com.pavi.blog.service.ArichivesService;
import com.pavi.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-12 20:26
 **/
@Controller
public class ArichivesShowController {

    @Autowired
    private ArichivesService arichivesService;



    @GetMapping("/arichives")
    public String toArichivesPage(Model model){


        Map<Integer,List<Blog>> blogMapByYear = arichivesService.listBlogByArichives();
        Integer count = 0;
        for (List<Blog> tempBlogList : blogMapByYear.values()) {
            count += tempBlogList.size();
        }
        model.addAttribute("blogMapByYear",blogMapByYear);
        model.addAttribute("count",count);
        return "arichives";

    }
}
