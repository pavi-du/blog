package com.pavi.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pavi.blog.mapper.TagMapper;
import com.pavi.blog.po.Tag;
import com.pavi.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 11:39
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Tag> listTagWithBlogTop(int count) {


        List<Tag> allTagList = tagMapper.listTagWithBlog();


        List<Tag> tagList = new ArrayList<>();
        //allTagList:
        //        //for (Tag tagOfAll : allTagList) {
        //        //    tagList:
        //        //    for (Tag tag : tagList) {
        //        //        if (tag.getTagName() != null && tag.getTagName().equals(tagOfAll.getTagName())) {
        //        //            Integer index = tagList.indexOf(tag);
        //            Tag t = tagList.get(index);
        //            t.getBlogList().addAll(tagOfAll.getBlogList());
        //            continue allTagList;
        //        }
        //    }
        //
        //    tagList.add(tagOfAll);
        //    Integer index = tagList.indexOf(tagOfAll);
        //    Tag t = tagList.get(index);
        //    t.getBlogList().addAll(tagOfAll.getBlogList());
        //}
        //List<Tag> resTagList = new ArrayList<>();
        //if(count<=tagList.size()){
        //    resTagList = tagList.subList(0, count);
        //}else {
        //    resTagList = tagList;
        //}

        return allTagList;
    }

    @Override
    public PageInfo<Tag> listTagByPagingWithBlog(Integer pageNum,Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList = tagMapper.listTagWithBlog();
        PageInfo<Tag> tagPageInfo = new PageInfo<Tag>(tagList);
        return tagPageInfo;
    }



    @Override
    public Tag getTagById(Long id) {
        Tag tag  = tagMapper.getTagById(id);

        return tag;
    }

    @Override
    public Boolean saveTag(Tag tag) {

        Integer saveTagCount = tagMapper.saveTag(tag);
        return saveTagCount==1;
    }

    @Override
    public Boolean updateTagById(Tag tag) {

        Integer updateTagCount = tagMapper.updateTagById(tag);
        return updateTagCount==1;
    }

    @Override
    public Boolean deleteTagById(Long id) {

        Integer deleteTagCount = tagMapper.deleteTagById(id);
        return deleteTagCount==1;
    }

    @Override
    public PageInfo<Tag> listTagByPaging(Integer pageNum, Integer pageSize) {


        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList = tagMapper.listTag();
        PageInfo<Tag> tagPageInfo = new PageInfo<>(tagList);

        return tagPageInfo;
    }


}
