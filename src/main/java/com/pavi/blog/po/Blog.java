package com.pavi.blog.po;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/5 13:31
 */
@Repository
public class Blog {

    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag; //标记
    private Integer views; //浏览次数

    // 赞赏
    private boolean appreciate;

    //转载声明
    private boolean reproducedStatement;
    // 评论
    private boolean comment;
    // 发布
    private boolean publish;
    // 推荐
    private boolean recommend;

    // 文章的描述信息
    private String description;

    private Date createTime;
    private Date updateTime;

    // "HTML,JAVA,HTML"
    private String tagIds;

    private Type type;
    private List<Tag> tagList = new ArrayList<>();
    private User user;
    private List<Comment> commentList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciate() {
        return appreciate;
    }

    public void setAppreciate(boolean appreciate) {
        this.appreciate = appreciate;
    }

    public boolean isReproducedStatement() {
        return reproducedStatement;
    }

    public void setReproducedStatement(boolean reproducedStatement) {
        this.reproducedStatement = reproducedStatement;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    
    public List<Long> tagIdsToTagIdList(){
        List<Long> tagIdList = new ArrayList<>();
        if(this.tagIds!=null && !tagIds.equals("")){
            String[] tagIdArray = this.tagIds.split(",");
            for (String tagIdStr : tagIdArray) {
                tagIdList.add(Long.parseLong(tagIdStr));
            }
        }
        return tagIdList;
    }

    public String tagListToTagIds(){
        StringBuffer tagIdsStringBuffer = new StringBuffer();
        if(this.tagList!=null){
            for (Tag tag : tagList) {
                tagIdsStringBuffer.append(tag.getId());
            }
        }
        this.setTagIds(tagIdsStringBuffer.toString());
        return this.tagIds;

    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciate=" + appreciate +
                ", reproducedStatement=" + reproducedStatement +
                ", comment=" + comment +
                ", publish=" + publish +
                ", recommend=" + recommend +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", tagIds='" + tagIds + '\'' +
                ", type=" + type +
                ", tagList=" + tagList +
                ", user=" + user +
                ", commentList=" + commentList +
                '}';
    }
}
