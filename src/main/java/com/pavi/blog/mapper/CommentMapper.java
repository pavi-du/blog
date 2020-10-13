package com.pavi.blog.mapper;

import com.pavi.blog.po.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-11 18:09
 **/
@Repository
public interface CommentMapper {


    Integer saveCommentByBlogId(Comment comment);

    List<Comment> listCommentByBlogId(Long blogId);

    List<Comment> listCommentWithChildrenCommentList(Long blogId);



    List<Comment> listCommentByIdAndParentId(Long parentId,Long blogId);

    Integer deleteCommentByBlogId(Long id);
}
