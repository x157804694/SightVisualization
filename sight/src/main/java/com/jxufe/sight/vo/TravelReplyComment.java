package com.jxufe.sight.vo;

import java.util.Date;

public class TravelReplyComment {

    private Long id;
    private String reply;
    private Date create_time;
    private String from_user_avatar;
    private String from_user_nickname;
    private String to_user_nickname;
    private Long comment_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getFrom_user_avatar() {
        return from_user_avatar;
    }

    public void setFrom_user_avatar(String from_user_avatar) {
        this.from_user_avatar = from_user_avatar;
    }

    public String getFrom_user_nickname() {
        return from_user_nickname;
    }

    public void setFrom_user_nickname(String from_user_nickname) {
        this.from_user_nickname = from_user_nickname;
    }

    public String getTo_user_nickname() {
        return to_user_nickname;
    }

    public void setTo_user_nickname(String to_user_nickname) {
        this.to_user_nickname = to_user_nickname;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public String toString() {
        return "ReplyComment{" +
                "id=" + id +
                ", reply='" + reply + '\'' +
                ", create_time=" + create_time +
                ", from_user_avatar='" + from_user_avatar + '\'' +
                ", from_user_nickname='" + from_user_nickname + '\'' +
                ", to_user_nickname='" + to_user_nickname + '\'' +
                ", comment_id=" + comment_id +
                '}';
    }
}
