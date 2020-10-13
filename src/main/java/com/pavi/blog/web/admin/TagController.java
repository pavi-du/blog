package com.pavi.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Tag;
import com.pavi.blog.service.TagService;
import com.pavi.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-11 13:35
 **/
@Controller
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/admin/tag")
    public String toTagPage(@RequestParam(name = "tagId",required = false)Long tagId,
                            Model model){

        if(tagId != null){
            Tag tag = tagService.getTagById(tagId);
            model.addAttribute("tag",tag);
        }

        return "admin/tags-input";
    }


    @PostMapping("/admin/tag/")
    public String saveTag(Tag tag){
        Boolean saveTagRes = tagService.saveTag(tag);
        if(!saveTagRes){

        }
        return "redirect:/admin/tags/1/5";
    }


    @ResponseBody
    @DeleteMapping("/admin/tag/{id}")
    public Result deleteTagById(@PathVariable(name = "id")Long id){
        Boolean deleteTagRes = tagService.deleteTagById(id);
        return new Result().setSuccess(true);
    }


    @PutMapping("/admin/tag/{id}")
    public String updateTagById(@PathVariable(name = "id")Long id, Tag tag){
        Boolean updateTagRes = tagService.updateTagById(tag);
        if(!updateTagRes){

        }
        return "redirect:/admin/tags/1/5";
    }


    @GetMapping("/admin/tags/{pageNum}/{pageSize}")
    public String listTagWithPaging(@PathVariable(name = "pageNum")Integer pageNum,
                                    @PathVariable(name = "pageSize")Integer pageSize,
                                    Model model){


        PageInfo<Tag> tagPageInfo = tagService.listTagByPaging(pageNum,pageSize);
        model.addAttribute("tagPageInfo",tagPageInfo);
        return "admin/tags";
    }


}
