package com.jxufe.sight.vo;

public class TravelImgs {

    private Long id;
    private String img_url;
    private Long travel_id;

    public Long getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(Long travel_id) {
        this.travel_id = travel_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "TravelImgs{" +
                "id=" + id +
                ", img_url='" + img_url + '\'' +
                ", travel_id='" + travel_id + '\'' +
                '}';
    }
}
