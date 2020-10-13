package com.pavi.blog.po;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 9:53
 */
@Repository
public class Tag {

    private Long id;
    private String tagName;

    private List<Blog> blogList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }



    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", blogList=" + blogList +
                '}';
    }


}
