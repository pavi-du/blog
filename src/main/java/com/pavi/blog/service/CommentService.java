package com.pavi.blog.service;

import com.pavi.blog.po.Comment;

import java.util.List;

public interface CommentService {

    Boolean saveCommentByBlogId(Comment comment);

    List<Comment> listComment(Long blogId);

    void deleteCommentByBlogId(Long id);
}
