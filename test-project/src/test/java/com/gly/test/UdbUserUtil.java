package com.gly.test;

public class UdbUserUtil {
    public UdbUserUtil() {
    }

    public static UserInfo getUserInfoIfExist() {
        return (UserInfo)MedContext.newInstance().getValue(MedContext.MedKey.USER_INFO, UserInfo.class);
    }

    public static UserInfo getUserInfoExpectedly() throws Exception {
        UserInfo userInfo = getUserInfoIfExist();
        if (userInfo == null) {
            throw new Exception();
        } else {
            return userInfo;
        }
    }

    public static Long getUsId() throws Exception {
        UserInfo userInfo = getUserInfoExpectedly();
        return userInfo.getUsId();
    }

    public static String getPhoneNo() throws Exception {
        UserInfo userInfo = getUserInfoExpectedly();
        return userInfo.getPhoneNo().toString();
    }
}
