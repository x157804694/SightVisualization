package com.jxufe.sight.updateDatabase.bean;

import java.io.Serializable;

public class SightInfoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sightId;
    private String sightName;
    private String intro;
    private String address;
    private String star;
    private String qunarPrice;
    private String saleCount;
    private String point;
    private String sightImgURL;
    private String province;
    private String city;

    public SightInfoBean() {
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

    public String getQunarPrice() {
        return qunarPrice;
    }

    public void setQunarPrice(String qunarPrice) {
        this.qunarPrice = qunarPrice;
    }

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "SightInfoBean{" +
                "sightId='" + sightId + '\'' +
                ", sightName='" + sightName + '\'' +
                ", intro='" + intro + '\'' +
                ", address='" + address + '\'' +
                ", star='" + star + '\'' +
                ", qunarPrice='" + qunarPrice + '\'' +
                ", saleCount='" + saleCount + '\'' +
                ", point='" + point + '\'' +
                ", sightImgURL='" + sightImgURL + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
