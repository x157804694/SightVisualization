package com.jxufe.sight.vo;

public class UserTravel {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long user_id;
    private Long travel_id;

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

    public Long getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(Long travel_id) {
        this.travel_id = travel_id;
    }

    @Override
    public String toString() {
        return "UserTravel{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", travel_id=" + travel_id +
                '}';
    }
}
