package com.fhit.test.microrocketmq.consumer;

import com.fhit.test.microrocketmq.CONST;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.http.StreamingHttpOutputMessage;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author wty
 * @create 2020-03-24 19:10
 */

public class RocketMqConsumer {

    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myConsumer");
        consumer.setNamesrvAddr(CONST.NAMESERVER_ADDR);

        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
//        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        try {
            consumer.subscribe("myTopicl", "*");

            //设置监听器，当生产者生产数据时，将数据推送给消费者
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    MessageExt messageExt = list.get(0);
                    String topic = messageExt.getTopic();
                    String tags = messageExt.getTags();
                    String keys = messageExt.getKeys();
                    try {
                        String body = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                        System.out.println("topic=" + topic + ",\ttags=" + tags + ",\tkeys=" + keys + ",\tbody=" + body);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    //此条消息消费成功，获取下一条数据
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
