package com.jxufe.sight.vo;

public class UserVote {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long user_id;
    private Long vote_id;

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

    public Long getVote_id() {
        return vote_id;
    }

    public void setVote_id(Long vote_id) {
        this.vote_id = vote_id;
    }

    @Override
    public String toString() {
        return "UserVote{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", vote_id=" + vote_id +
                '}';
    }
}
