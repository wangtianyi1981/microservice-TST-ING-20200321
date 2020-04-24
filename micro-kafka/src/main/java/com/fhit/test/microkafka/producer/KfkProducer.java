package com.fhit.test.microkafka.producer;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author wty
 * @create 2020-04-24 18:29
 */
public class KfkProducer {
    static String topic = "topictest";
//    static String topic = "newtopictest";
    public static void main(String[] args) {
//        create();
        // 执行后默认生成新的topic

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("bootstrap.servers", "192.168.2.128:9092,192.168.2.129:9092,192.168.2.130:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
//        String topic = "topictest";
//        String topic = "newtopictest";
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord(topic, "idea-key1", "java-message 1"));
        producer.send(new ProducerRecord(topic, "idea-key1", "java-message 1"));
        producer.send(new ProducerRecord(topic, "idea-key1", "java-message 2"));
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 1"));
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 2"));
        producer.send(new ProducerRecord(topic, "idea-key2", "java-message 3"));

        producer.close();
    }

    public static void create() {
        //  创建topic
//        String topic = "newtopictest";
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.2.128:12181");
        AdminClient adminClient = AdminClient.create(props);
        ArrayList<NewTopic> topics = new ArrayList<NewTopic>();
        NewTopic newTopic = new NewTopic(topic, 1, (short) 1);//   创建   topic ： topic-trx
        topics.add(newTopic);
        CreateTopicsResult result = adminClient.createTopics(topics);
        try {
            result.all().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}






