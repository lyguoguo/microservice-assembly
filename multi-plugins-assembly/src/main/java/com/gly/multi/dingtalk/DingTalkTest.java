package com.gly.multi.dingtalk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gly.multi.config.DingTalkConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ProjectName: microservice-assembly
 * @Package: com.gly.multi.dingtalk
 * @ClassName: DingTalkTest
 * @Author: lvye.guo
 * @Description: 钉钉群机器人测试
 * @Date: 2020/6/9 15:10
 * @Version: 1.0
 */
@Slf4j
@Component
public class DingTalkTest {



    @Resource
    private DingTalkConfig dingTalkConfig;

    public void dingTalkTest() throws JSONException {

    }
}
