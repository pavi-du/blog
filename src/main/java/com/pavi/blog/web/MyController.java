package com.pavi.blog.web;

import com.pavi.blog.exception.NotFoundException;
import com.pavi.blog.po.Tag;
import com.pavi.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 11:38
 */
@RestController
public class MyController {


    @Autowired
    private TagService tagService;

    @GetMapping("/listTag")
    public List<Tag> listTag(){

        return tagService.listTag();
    }

    @ResponseBody
    @GetMapping("/test")
    public String test(){

       int i = 10/0;
        return "test";
    }
}
