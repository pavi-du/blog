package com.pavi.blog.web;

import com.pavi.blog.po.Comment;
import com.pavi.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-11 18:02
 **/

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public String saveComment(Comment comment){


        comment.setCreateTime(new Date());
        comment.setAvatar("https://profile.csdnimg.cn/A/9/D/2_pavicn");
        Boolean saveCommentRes = commentService.saveCommentByBlogId(comment);

        return "blog::comment";
    }

    @GetMapping("/comments/{blogId}")
    public String listComment(@PathVariable(name = "blogId")Long blogId,
                              Model model){

        List<Comment> commentList =  commentService.listComment(blogId);
        model.addAttribute("commentList",commentList);
        return "blog :: comment";
    }
}
