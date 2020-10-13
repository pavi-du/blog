package com.pavi.blog.mapper;


import com.pavi.blog.po.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagMapper {




    Integer saveTag(Tag tag);

    Integer deleteTagById(Long id);

    Integer updateTagById(Tag tag);

    Tag getTagById(Long id);

    List<Tag> listTag();

    List<Tag> listTagWithBlog();



}
