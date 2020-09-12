package com.arcsoft.face;

/**
 * 激活文件信息类
 */
public class ActiveFileInfo {

    /**
     * appId
     */
    private String appId;
    /**
     * sdkKey
     */
    private String sdkKey;
    /**
     * activeKey
     */
    private String activeKey;
    /**
     * 平台类型
     */
    private String platform;
    /**
     * sdk类型
     */
    private String sdkType;
    /**
     * sdk版本号
     */
    private String sdkVersion;
    /**
     * 文件版本号
     */
    private String fileVersion;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 创建一个空的激活文件信息对象
     */
    public ActiveFileInfo() {
    }

    /**
     * 获取appId
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 获取sdkKey
     * @return sdkKey
     */
    public String getSdkKey() {
        return sdkKey;
    }

    /**
     * 获取平台类型
     * @return 平台类型
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 获取sdk类型
     * @return sdk类型
     */
    public String getSdkType() {
        return sdkType;
    }

    /**
     * 获取sdk版本号
     * @return sdk版本号
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * 获取文件版本号
     * @return 文件版本号
     */
    public String getFileVersion() {
        return fileVersion;
    }

    /**
     * 获取开始时间
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 获取结束时间
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSdkKey(String sdkKey) {
        this.sdkKey = sdkKey;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setSdkType(String sdkType) {
        this.sdkType = sdkType;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取格式化的激活文件信息
     *
     * @return 格式化的激活文件信息
     */
    @Override
    public String toString() {
        return this.appId + ',' + this.sdkKey + ',' + this.platform + ','
                + this.sdkType + ',' + this.sdkVersion + ',' + this.fileVersion + ','
                + this.startTime + ',' + this.endTime;
    }
}
