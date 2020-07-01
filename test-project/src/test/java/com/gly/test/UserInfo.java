package com.gly.test;

public class UserInfo {
    public static final String US_ID = "usId";
    public static final String US_ID_32 = "usId32";
    public static final String PHONE_NO = "phoneNo";
    public static final String USERNAME = "username";
    public static final String TERMINAL_TYPE = "terminalType";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String UNICODE = "unicode";
    public static final String CLIENT_ID = "clientId";
    public static final String AREA_ID = "areaId";
    public static final String RESOURCE_ID = "resourceId";
    public static final String THIRD_TYPE = "thirdType";
    public static final String APP_ID = "appId";
    public static final String OPEN_ID = "openId";
    public static final String OPEN_US_ID = "openUsId";
    private Long usId;
    private String usId32;
    private Long phoneNo;
    private String username;
    private Integer terminalType;
    private String accessToken;
    private String unicode;
    private String clientId;
    private String areaId;
    private String resourceId;
    private Integer thirdType;
    private String appId;
    private String openId;
    private String openUsId;

    public UserInfo() {
    }

    public Long getUsId() {
        return this.usId;
    }

    public void setUsId(Long usId) {
        this.usId = usId;
    }

    public String getUsId32() {
        return this.usId32;
    }

    public void setUsId32(String usId32) {
        this.usId32 = usId32;
    }

    public Long getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getThirdType() {
        return this.thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenUsId() {
        return this.openUsId;
    }

    public void setOpenUsId(String openUsId) {
        this.openUsId = openUsId;
    }

    public String toString() {
        return "UserInfo{usId=" + this.usId + ", phoneNo=" + this.phoneNo + ", username='" + this.username + '\'' + ", terminalType=" + this.terminalType + ", accessToken='" + this.accessToken + '\'' + ", unicode='" + this.unicode + '\'' + ", clientId='" + this.clientId + '\'' + ", areaId='" + this.areaId + '\'' + ", resourceId='" + this.resourceId + '\'' + '}';
    }
}
