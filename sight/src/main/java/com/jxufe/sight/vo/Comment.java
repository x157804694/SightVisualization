package com.jxufe.sight.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {

    private Long id;
    private String comment;
    private Date create_time;
    private Long from_uid;
    private Long vote_id;
    private UserInfoVO user;
    private List<ReplyComment> replyComments = new ArrayList<>();

    public UserInfoVO getUser() {
        return user;
    }

    public void setUser(UserInfoVO user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getFrom_uid() {
        return from_uid;
    }

    public void setFrom_uid(Long from_uid) {
        this.from_uid = from_uid;
    }

    public Long getVote_id() {
        return vote_id;
    }

    public void setVote_id(Long vote_id) {
        this.vote_id = vote_id;
    }

    public List<ReplyComment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<ReplyComment> replyComments) {
        this.replyComments = replyComments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", create_time=" + create_time +
                ", from_uid=" + from_uid +
                ", vote_id=" + vote_id +
                ", replyComments=" + replyComments +
                '}';
    }
}
