package com.jxufe.sight.vo;

public class VoteQuery {
    Long Id;
    Long voteId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    @Override
    public String toString() {
        return "VoteQuery{" +
                "id=" + Id +
                ", voteId=" + voteId +
                '}';
    }
}
