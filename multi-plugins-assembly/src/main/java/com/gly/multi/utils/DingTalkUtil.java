package com.gly.multi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

/**
 * @ProjectName: microservice-assembly
 * @Package: com.gly.multi.utils
 * @ClassName: DingTalkUtil
 * @Author: lvye.guo
 * @Description: 钉钉机器人工具类
 * @Date: 2020/6/9 16:01
 * @Version: 1.0
 */
public class DingTalkUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(DingTalkUtil.class);

    private static String MSG_TYPE = "msgtype";
    private static String MSG_TYPE_TEXT = "text";
    private static String CONTENT = "content";
    private static String IS_AT_ALL = "isAtAll";
    private static String AT = "at";

    private static String ERROR_RESPONSE_CODE = "errcode";

    public static void post(String url,String sendMessage) {
        LOGGER.info("【钉钉群机器人】接收到请求参数：url -> {} sendMessage -> {}",url,sendMessage);
        HttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        JSONObject httpBody = buildBody(sendMessage);
        LOGGER.info("【钉钉群机器人】发送消息体： httpBody -> {}",httpBody);
        httpPost.setEntity(new StringEntity(httpBody.toJSONString(), "utf-8"));
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("【钉钉群机器人】请求发送异常： e -> {}",e.getMessage());
            return;
        }
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = null;
            try {
                result = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.error("【钉钉群机器人】响应异常： e -> {}",e.getMessage());
                return;
            }
            LOGGER.info("【钉钉群机器人】钉钉服务端返回信息:{}" + result);
            HashMap resultData = JSON.parseObject(result,HashMap.class);
            boolean resultStatus = "0".equals(String.valueOf(resultData.get(ERROR_RESPONSE_CODE)));
            if (!resultStatus) {
                LOGGER.info("【钉钉群机器人】钉钉服务端响应失败：{}",result);
            }
        }
    }

    private static JSONObject buildBody(String sendMessage){
        //msgtype
        JSONObject httpBody = new JSONObject();
        httpBody.put(MSG_TYPE,MSG_TYPE_TEXT);

        //text
        JSONObject text=new JSONObject();
        text.put(CONTENT,sendMessage);
        httpBody.put(MSG_TYPE_TEXT,text);

        //at
        JSONObject at=new JSONObject();
        at.put(IS_AT_ALL,true);
        httpBody.put(AT,at);

        return httpBody;
    }
}
