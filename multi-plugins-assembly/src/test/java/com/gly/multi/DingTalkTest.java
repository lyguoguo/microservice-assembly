package com.gly.multi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gly.multi.config.DingTalkConfig;
import com.gly.multi.utils.DingTalkUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @ProjectName: microservice-assembly
 * @Package: com.gly.multi
 * @ClassName: DingTalkTest
 * @Author: lvye.guo
 * @Description:
 * @Date: 2020/6/9 16:40
 * @Version: 1.0
 */
public class DingTalkTest extends MultiPluginsAssemblyApplicationTests{

    @Resource
    private DingTalkConfig dingTalkConfig;

    @Test
    public void dingTalkTest() throws IOException {
        String sendMessage ="监控报警测试： ding-talk-test 服务异常 ，报警时间："+ DateUtil.formatAsDatetime(new Date());
        DingTalkUtil.post(dingTalkConfig.getPostUrl(),sendMessage);
    }


}
