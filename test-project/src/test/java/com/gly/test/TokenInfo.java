package com.gly.test;

import com.alibaba.fastjson.JSON;

public class TokenInfo {
    private static final long serialVersionUID = 7919401588517326896L;
    public static final String US_ID = "usId";
    public static final String PHONE_NO = "phoneNo";
    public static final String TERMINAL_TYPE = "terminalType";
    public static final String PUSH_TOKEN = "pushToken";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String UNICODE = "unicode";
    public static final String CLIENT_ID = "clientId";
    public static final String AREA_ID = "areaId";
    public static final String RESOURCE_ID = "resourceId";
    public static final String USERNAME = "userName";
    public static final String EMAIL = "email";
    public static final String EXTENDAUTH = "extendAuth";
    public static final String COL_US_ID = "us_id";
    public static final String COL_PHONE_NO = "phone_no";
    public static final String COL_TERMINAL_TYPE = "terminal_type";
    public static final String COL_PUSH_TOKEN = "push_token";
    public static final String COL_ACCESS_TOKEN = "access_token";
    public static final String COL_UNICODE = "unicode";
    public static final String COL_CLIENT_ID = "client_id";
    public static final String COL_AREA_ID = "area_id";
    public static final String COL_RESOURCE_ID = "resource_id";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_EMAIL = "email";
    public static final String COL_EXTEND_AUTH = "extend_auth";
    public static final String COL_USID32 = "US_ID_32";
    private Long usId;
    private Long phoneNo;
    private Integer terminalType;
    private String pushToken;
    private String accessToken;
    private String unicode;
    private String clientId;
    private String areaId;
    private String resourceId;
    private String email;
    private String extendAuth;
    private String userName;
    private String usId32;
    private Integer thirdType;
    private String appId;
    private String openId;
    private String openUsId;

    public TokenInfo() {
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Long getUsId() {
        return this.usId;
    }

    public void setUsId(Long usId) {
        this.usId = usId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtendAuth() {
        return this.extendAuth;
    }

    public void setExtendAuth(String extendAuth) {
        this.extendAuth = extendAuth;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsId32() {
        return this.usId32;
    }

    public void setUsId32(String usId32) {
        this.usId32 = usId32;
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
        return JSON.toJSONString(this);
    }
}
