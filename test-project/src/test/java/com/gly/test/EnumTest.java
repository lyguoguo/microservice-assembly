package com.gly.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

public class EnumTest {
    @Test
    public void enumTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUnicode("22525252");
        userInfo.setAreaId(null);
        userInfo.setResourceId(null);
        userInfo.setClientId(null);
        userInfo.setUsId(null);
        userInfo.setUsId32(null);
        userInfo.setPhoneNo(null);
        userInfo.setUsername("guoly");
        userInfo.setTerminalType(1);
        userInfo.setThirdType(3);
        userInfo.setAppId("313111");
        userInfo.setOpenId("313131");
        userInfo.setOpenUsId("31313141");
        MedContext.newInstance().setValue(MedContext.MedKey.USER_INFO, userInfo);
        TokenInfo tokenInfo = new TokenInfo();
        BeanUtils.copyProperties(userInfo, tokenInfo);
        MedContext.newInstance().setValue(MedContext.MedKey.UDB_TOKEN_INFO, tokenInfo);

        UserInfo result = UdbUserUtil.getUserInfoIfExist();
        Assert.notNull(result,"用户信息不存在");
    }


}
