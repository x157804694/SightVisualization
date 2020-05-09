package com.jxufe.sight.vo;

public class UserTravelAppreciate {

    private Long id;
    private Long user_id;
    private Long appreciatetravel_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAppreciatetravel_id() {
        return appreciatetravel_id;
    }

    public void setAppreciatetravel_id(Long appreciatetravel_id) {
        this.appreciatetravel_id = appreciatetravel_id;
    }

    @Override
    public String toString() {
        return "UserTravelAppreciate{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", appreciatetravel_id=" + appreciatetravel_id +
                '}';
    }
}
