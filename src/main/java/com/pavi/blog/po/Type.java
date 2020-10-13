package com.pavi.blog.po;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 9:48
 */
@Repository
public class Type {

    private Long id;
    private String typeName;


    private List<Blog> blogList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", blogList=" + blogList +
                '}';
    }
}
