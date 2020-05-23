package com.jxufe.sight.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "self.upload")
public class UploadPathManagement {
    private String travelImgsAccessPath;
    private String travelImgsResourcePath;
    private String avatarsAccessPath;
    private String avatarsResourcePath;

    public UploadPathManagement() {
    }

    public String getTravelImgsAccessPath() {
        return travelImgsAccessPath;
    }

    public void setTravelImgsAccessPath(String travelImgsAccessPath) {
        this.travelImgsAccessPath = travelImgsAccessPath;
    }

    public String getTravelImgsResourcePath() {
        return travelImgsResourcePath;
    }

    public void setTravelImgsResourcePath(String travelImgsResourcePath) {
        this.travelImgsResourcePath = travelImgsResourcePath;
    }

    public String getAvatarsAccessPath() {
        return avatarsAccessPath;
    }

    public void setAvatarsAccessPath(String avatarsAccessPath) {
        this.avatarsAccessPath = avatarsAccessPath;
    }

    public String getAvatarsResourcePath() {
        return avatarsResourcePath;
    }

    public void setAvatarsResourcePath(String avatarsResourcePath) {
        this.avatarsResourcePath = avatarsResourcePath;
    }
}
