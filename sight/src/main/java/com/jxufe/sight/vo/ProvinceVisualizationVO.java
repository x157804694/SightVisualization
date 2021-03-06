package com.jxufe.sight.vo;

import java.io.Serializable;

public class ProvinceVisualizationVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String sightId;
    private String sightName;
    private String intro;
    private String address;
    private String star;
    private String point;
    private String sightImgURL;
    private String city;
    private float qunarPrice;
    private int saleCount;
    private int goodCommentAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSightId() {
        return sightId;
    }

    public void setSightId(String sightId) {
        this.sightId = sightId;
    }

    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getSightImgURL() {
        return sightImgURL;
    }

    public void setSightImgURL(String sightImgURL) {
        this.sightImgURL = sightImgURL;
    }

    public float getQunarPrice() {
        return qunarPrice;
    }

    public void setQunarPrice(float qunarPrice) {
        this.qunarPrice = qunarPrice;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getGoodCommentAmount() {
        return goodCommentAmount;
    }

    public void setGoodCommentAmount(int goodCommentAmount) {
        this.goodCommentAmount = goodCommentAmount;
    }

    @Override
    public String toString() {
        return "SightBasicInfoVO{" +
                "id=" + id +
                ", sightId='" + sightId + '\'' +
                ", sightName='" + sightName + '\'' +
                ", intro='" + intro + '\'' +
                ", address='" + address + '\'' +
                ", star='" + star + '\'' +
                ", point='" + point + '\'' +
                ", sightImgURL='" + sightImgURL + '\'' +
                ", city='" + city + '\'' +
                ", qunarPrice=" + qunarPrice +
                ", saleCount=" + saleCount +
                ", goodCommentAmount=" + goodCommentAmount +
                '}';
    }
}
