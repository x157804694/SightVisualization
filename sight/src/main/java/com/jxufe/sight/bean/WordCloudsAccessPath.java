package com.jxufe.sight.bean;

import java.io.Serializable;

public class WordCloudsAccessPath implements Serializable {
    private static final long serialVersionUID=1L;

    private String goodaPath;
    private String goodnPath;
    private String badaPath;
    private String badnPath;

    public void setAll(String path){
        goodaPath=goodnPath=badaPath=badnPath=path;
    }

    public String getGoodaPath() {
        return goodaPath;
    }

    public void setGoodaPath(String goodaPath) {
        this.goodaPath = goodaPath;
    }

    public String getGoodnPath() {
        return goodnPath;
    }

    public void setGoodnPath(String goodnPath) {
        this.goodnPath = goodnPath;
    }

    public String getBadaPath() {
        return badaPath;
    }

    public void setBadaPath(String badaPath) {
        this.badaPath = badaPath;
    }

    public String getBadnPath() {
        return badnPath;
    }

    public void setBadnPath(String badnPath) {
        this.badnPath = badnPath;
    }
}
