package com.jxufe.sight.vo;

public class VoteOption {
    private Long id;
    private String option_name;
    private Long vote_num = new Long("0");
    private Double ratio = new Double("0.00");
    private Long voteNum = new Long("0");
    private VoteInfoVO voteInfoVO;

    public Long getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Long voteNum) {
        this.voteNum = voteNum;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getOption_name() {
        return option_name;
    }

    public void setOption_name(String option_name) {
        this.option_name = option_name;
    }

    public Long getVote_num() {
        return vote_num;
    }

    public void setVote_num(Long vote_num) {
        this.vote_num = vote_num;
    }

    public VoteInfoVO getVoteInfoVO() {
        return voteInfoVO;
    }

    public void setVoteInfoVO(VoteInfoVO voteInfoVO) {
        this.voteInfoVO = voteInfoVO;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "id=" + id +
                ", option_name='" + option_name + '\'' +
                ", vote_num=" + vote_num +
                ", ratio=" + ratio +
                ", voteNum=" + voteNum +
                ", voteInfoVO=" + voteInfoVO +
                '}';
    }
}
