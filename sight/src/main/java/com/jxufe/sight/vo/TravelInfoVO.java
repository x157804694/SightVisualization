package com.jxufe.sight.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TravelInfoVO {

    private Long id;
    private String title;
    private String description;
    private Date create_time; //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String[] options;
    private Long appreciate_num = new Long("0"); //点赞数
    private Long user_id;
    private UserInfoVO userInfoVO;
    private List<TravelImgs> travelImgs = new ArrayList<>();
    private List<TravelComment> travelComments = new ArrayList<>();

    public List<TravelImgs> getTravelImgs() {
        return travelImgs;
    }

    public void setTravelImgs(List<TravelImgs> travelImgs) {
        this.travelImgs = travelImgs;
    }

    public List<TravelComment> getTravelComments() {
        return travelComments;
    }

    public void setTravelComments(List<TravelComment> travelComments) {
        this.travelComments = travelComments;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


    public Long getAppreciate_num() {
        return appreciate_num;
    }

    public void setAppreciate_num(Long appreciate_num) {
        this.appreciate_num = appreciate_num;
    }

    public UserInfoVO getUserInfoVO() {
        return userInfoVO;
    }

    public void setUserInfoVO(UserInfoVO userInfoVO) {
        this.userInfoVO = userInfoVO;
    }

    @Override
    public String toString() {
        return "TravelInfoVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", options=" + Arrays.toString(options) +
                ", appreciate_num=" + appreciate_num +
                ", user_id=" + user_id +
                ", userInfoVO=" + userInfoVO +
                ", travelImgs=" + travelImgs +
                ", travelComments=" + travelComments +
                '}';
    }
}
