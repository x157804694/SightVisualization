package com.jxufe.sight.vo;

import java.io.Serializable;

public class SightCommentsInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sightId;
    private String good_n;//好评的名词文本
    private String good_a;//好评的形容词文本
    private String bad_n;//差评的名词文本
    private String bad_a;//差评的形容词文本
    private int goodCommentAmount;
    private int badCommentAmount;
    private int sumAmount;

    public boolean isAllNull(){
        return  good_n==null&&good_a==null&&bad_n==null&&bad_a==null;
    }
    public String getSightId() {
        return sightId;
    }

    public void setSightId(String sightId) {
        this.sightId = sightId;
    }

    public String getGood_n() {
        return good_n;
    }

    public void setGood_n(String good_n) {
        this.good_n = good_n;
    }

    public String getGood_a() {
        return good_a;
    }

    public void setGood_a(String good_a) {
        this.good_a = good_a;
    }

    public String getBad_n() {
        return bad_n;
    }

    public void setBad_n(String bad_n) {
        this.bad_n = bad_n;
    }

    public String getBad_a() {
        return bad_a;
    }

    public void setBad_a(String bad_a) {
        this.bad_a = bad_a;
    }

    public int getGoodCommentAmount() {
        return goodCommentAmount;
    }

    public void setGoodCommentAmount(int goodCommentAmount) {
        this.goodCommentAmount = goodCommentAmount;
    }

    public int getBadCommentAmount() {
        return badCommentAmount;
    }

    public void setBadCommentAmount(int badCommentAmount) {
        this.badCommentAmount = badCommentAmount;
    }

    public int getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(int sumAmount) {
        this.sumAmount = sumAmount;
    }

    @Override
    public String toString() {
        return "SightCommentsInfoVO{" +
                "sightId='" + sightId + '\'' +
                ", good_n='" + good_n.substring(0,20) + '\'' +
                ", good_a='" + good_a.substring(0,20) + '\'' +
                ", bad_n='" + bad_n.substring(0,20) + '\'' +
                ", bad_a='" + bad_a.substring(0,20) + '\'' +
                ", goodCommentAmount=" + goodCommentAmount +
                ", badCommentAmount=" + badCommentAmount +
                ", sumAmount=" + sumAmount +
                '}';
    }
}
