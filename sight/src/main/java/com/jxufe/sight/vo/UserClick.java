/**
 * @Description:
 * @Package: com.jxufe.sight.vo
 * @ClassName: SightCategory
 * @Author: 徐鼎立
 * @Date: 2020/5/11 20:32
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.vo;

public class UserClick {
    private Long id;
    private String username;
    private String sightId;
    private Integer clickNum;



    public UserClick(String username, String sightId) {
        this.username = username;
        this.sightId = sightId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSightId() {
        return sightId;
    }

    public void setSightId(String sightId) {
        this.sightId = sightId;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer sightNum) {
        this.clickNum = sightNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
