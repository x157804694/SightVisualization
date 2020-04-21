package com.jxufe.sight.vo;

public class UserVoteAppreciate {

    private Long id;
    private Long user_id;
    private Long appreciatevote_id;

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

    public Long getAppreciatevote_id() {
        return appreciatevote_id;
    }

    public void setAppreciatevote_id(Long appreciatevote_id) {
        this.appreciatevote_id = appreciatevote_id;
    }

    @Override
    public String toString() {
        return "UserVoteAppreciate{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", appreciatevote_id=" + appreciatevote_id +
                '}';
    }
}
