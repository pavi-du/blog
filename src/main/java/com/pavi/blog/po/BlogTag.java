package com.pavi.blog.po;

import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/6 10:05
 */
@Repository
public class BlogTag {

    private Long id;
    private Blog blog;
    private Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "id=" + id +
                ", blog=" + blog +
                ", tag=" + tag +
                '}';
    }
}
