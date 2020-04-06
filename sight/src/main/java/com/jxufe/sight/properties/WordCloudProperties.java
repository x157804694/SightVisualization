package com.jxufe.sight.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myself.wordCloud")
public class WordCloudProperties {
    private String pyFilePath;//指定执行的py文件
    private String picturesDirectory;//指定存放词云图片的目录
    private String accessPath;//前台访问图片的路径
    private String nullPictureName;//空的词云图片名
    private String errorPictureName;//执行错误时返回的图片名

    public WordCloudProperties() {
    }

    public String getPyFilePath() {
        return pyFilePath;
    }

    public void setPyFilePath(String pyFilePath) {
        this.pyFilePath = pyFilePath;
    }

    public String getPicturesDirectory() {
        return picturesDirectory;
    }

    public void setPicturesDirectory(String picturesDirectory) {
        this.picturesDirectory = picturesDirectory;
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath;
    }

    public String getNullPictureName() {
        return nullPictureName;
    }

    public void setNullPictureName(String nullPictureName) {
        this.nullPictureName = nullPictureName;
    }

    public String getErrorPictureName() {
        return errorPictureName;
    }

    public void setErrorPictureName(String errorPictureName) {
        this.errorPictureName = errorPictureName;
    }

    @Override
    public String toString() {
        return "WordCloudProperties{" +
                "pyFilePath='" + pyFilePath + '\'' +
                ", picturesDirectory='" + picturesDirectory + '\'' +
                ", accessPath='" + accessPath + '\'' +
                ", nullPictureName='" + nullPictureName + '\'' +
                ", errorPictureName='" + errorPictureName + '\'' +
                '}';
    }
}
