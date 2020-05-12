/**
 * @Description:
 * @Package: com.jxufe.sight.vo
 * @ClassName: SightCategory
 * @Author: 徐鼎立
 * @Date: 2020/5/11 21:47
 * @version: 1.0
 * Copyright (c) 2020,All Rights Reserved.
 */
package com.jxufe.sight.vo;

public class SightCategory {
    private Long id;
    private String sightId;
    private Integer type;
    private Integer clickNum;

    @Override
    public String toString() {
        return "SightCategory{" +
                "id=" + id +
                ", sightId='" + sightId + '\'' +
                ", type=" + type +
                ", clickNum=" + clickNum +
                '}';
    }

    public SightCategory(String sightId) {
        this.sightId = sightId;
    }

    public String getSightId() {
        return sightId;
    }

    public void setSightId(String sightId) {
        this.sightId = sightId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }
}
