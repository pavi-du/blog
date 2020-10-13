package com.pavi.blog.service.impl;

import com.pavi.blog.mapper.CommentMapper;
import com.pavi.blog.po.Comment;
import com.pavi.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;


/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-11 18:06
 **/
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Boolean saveCommentByBlogId(Comment comment) {
        Integer saveCommentCount = commentMapper.saveCommentByBlogId(comment);
        return saveCommentCount==1;
    }

    @Override
    public List<Comment> listComment(Long blogId) {

        List<Comment> parentCommentList = commentMapper.listCommentByIdAndParentId(null, blogId);
        for (Comment rootComment : parentCommentList) {
            setChildrenCommment(rootComment,rootComment,blogId);
        }

        //List<Comment> tempCommentListWithChildrenCommentList = commentMapper.listCommentWithChildrenCommentList(blogId);
        //List<Comment> tempCommentList = commentMapper.listCommentByBlogId(blogId);
        //List<Comment> commentList = new ArrayList<>();
        //
        ////commentList.addAll(tempCommentList);
        ////commentList.addAll(tempCommentListWithChildrenCommentList);
        //List<Long> commentIdList = new ArrayList<>();
        //for (Comment comment : tempCommentListWithChildrenCommentList) {
        //    commentIdList.add(comment.getId());
        //    commentList.add(comment);
        //}
        //for (Comment comment : tempCommentList) {
        //    if(!commentIdList.contains(comment.getId())){
        //        commentList.add(comment);
        //    }
        //}
        //
        //generateCommentList(commentList);
        //
        //
        //List<Comment> parentCommentList = getParentCommentList(commentList);
        //for (Comment comment : parentCommentList) {
        //    addChildCommentList(comment,comment.getChildrenCommentList());
        //}

        return parentCommentList;
    }

    @Override
    public void deleteCommentByBlogId(Long id) {
        commentMapper.deleteCommentByBlogId(id);
    }

    public void listCommentMethod1(Long blogId){
        List<Comment> parentCommentList = commentMapper.listCommentByIdAndParentId(null, blogId);
        for (Comment rootComment : parentCommentList) {
            setChildrenCommment(rootComment,rootComment,blogId);
        }
    }

    public void setChildrenCommment(Comment rootComment,Comment parentComment,Long blogId){
        List<Comment> tempCommentList = commentMapper.listCommentByIdAndParentId(parentComment.getId(), blogId);

        if(parentComment != rootComment){
            parentComment.getChildrenCommentList().addAll(tempCommentList);
        }
        for (Comment comment : tempCommentList) {
            comment.setParentComment(parentComment);
            List<Comment> commentList = commentMapper.listCommentByIdAndParentId(comment.getId(),blogId);
            if(commentList.size()>0){
                setChildrenCommment(rootComment,comment,blogId);
            }
        }
        rootComment.getChildrenCommentList().addAll(tempCommentList);
    }




    public void generateCommentList(List<Comment> commentList){



    }

    public List<Comment> getParentCommentList(List<Comment> commentList){

        List<Comment> commentListRes = new ArrayList<>();
        for (Comment comment : commentList) {
            if(comment.getParentId()==null){
                commentListRes.add(comment);
            }
        }

        return commentListRes;
    }

    public Comment addChildCommentList(Comment comment,List<Comment> childCommentList){

        for (Comment commentOfChildCommentList : childCommentList) {

            if(!comment.getChildrenCommentList().contains(commentOfChildCommentList)){
                comment.getChildrenCommentList().add(commentOfChildCommentList);
                //commentOfChildCommentList.setParentComment(comment);
                //commentOfChildCommentList.setParentId(comment.getId());
            }

            if(commentOfChildCommentList.getChildrenCommentList().size()>0){

                addChildCommentList(comment,commentOfChildCommentList.getChildrenCommentList());
            }
        }

        return comment;
    }
}
