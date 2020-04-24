package com.fhit.test.micromapreduce.producer;


import com.fhit.test.micromapreduce.CONST;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author wty
 * @create 2020-04-24 18:29
 */
public class RocketMqProducer {
    public static void main(String[] args) {
        //创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("myProducer");
        producer.setNamesrvAddr(CONST.NAMESERVER_ADDR);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        //生成消息（生产主题和数据）
        for (int i = 0; i < 10; i++) {
            //topic：主题（一级目录）
            //tags：标签（二级目录）
            //key+body：以key-value的形式存放内容
            Message message = new Message("myTopicl", "myTag1", "key" + i, ("testMq" + i).getBytes());
            try {
                SendResult result = producer.send(message);
                System.out.println("发送成功：" + result);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (RemotingException e) {
                e.printStackTrace();
            } catch (MQBrokerException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        producer.shutdown();
    }
}






