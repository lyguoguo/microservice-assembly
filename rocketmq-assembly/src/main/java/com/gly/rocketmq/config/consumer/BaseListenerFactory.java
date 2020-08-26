package com.gly.rocketmq.config.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: yt-med
 * @Package: com.yuntai.cons.msg.mq.listener
 * @ClassName: BaseMQEventListener
 * @Author: lvye.guo
 * @Description: 消息队列监听基类
 * @Date: 2020/6/2 16:16
 * @Version: 1.0
 */
@Component
public class BaseListenerFactory implements MessageListenerConcurrently {

    private final static Logger logger = LogManager.getLogger(BaseListenerFactory.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                    ConsumeConcurrentlyContext consumeConcurrentlyContext){
        logger.info("【消息监听】收到队列消息, 消息条数 => {}", list.size());
        if (list.size() == 0){
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt message = list.get(0);
        try {
            //逐条消费
            String sendMessage = new String(message.getBody(), RemotingHelper.DEFAULT_CHARSET);
            logger.info(" BaseListenerFactory Message Consumer: Handle New Message: messageId: {} ,topic: {} ,tags: {} ,messageBody: {}",
                    message.getMsgId() ,
                    message.getTopic() ,
                    message.getTags(),
                    sendMessage);
            String topic = message.getTopic();
            String tags = message.getTags();
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("Consume Message Error!!", e);
            //抛出异常时，返回ConsumeConcurrentlyStatus.RECONSUME_LATER，尝试重试。当重试指定次数后返回ConsumeConcurrentlyStatus.CONSUME_SUCCESS
            int reconsumeTimes = message.getReconsumeTimes();
            logger.error("Now Retry Times: {}", reconsumeTimes);
            if (reconsumeTimes >= 3) {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }
}
