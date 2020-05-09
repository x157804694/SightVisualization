package com.jxufe.sight.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelComment {

    private Long id;
    private String comment;
    private Date create_time;
    private Long from_uid;
    private Long travel_id;
    private UserInfoVO user;
    private List<TravelReplyComment> travelReplyComments = new ArrayList<>();

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

    public Long getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(Long travel_id) {
        this.travel_id = travel_id;
    }

    public List<TravelReplyComment> getTravelReplyComments() {
        return travelReplyComments;
    }

    public void setTravelReplyComments(List<TravelReplyComment> travelReplyComments) {
        this.travelReplyComments = travelReplyComments;
    }

    @Override
    public String toString() {
        return "TravelComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", create_time=" + create_time +
                ", from_uid=" + from_uid +
                ", travel_id=" + travel_id +
                ", user=" + user +
                ", travelReplyComments=" + travelReplyComments +
                '}';
    }
}
