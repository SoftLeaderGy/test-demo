package com.kafkastart.demo.demos.web.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/11 15:05
 */

/**
 * 消费者：消费消息
 */
public class CustomConsumer {
    public static void main(String[] args) {
        // 创建消费者的配置对象
        Properties properties = new Properties();
        // 给消费者配置对象添加参数
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // 配置序列化 必须
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // 设置消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, " test");
        // 创建消费者对象

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        // 添加消费者订阅的主题topic，可以添加多个
        ArrayList<String> topics = new ArrayList<>();
        topics.add("first");
        topics.add("topic1");
        kafkaConsumer.subscribe(topics);
        // 拉取数据
        while (true) {
            // 每隔1s消费一批数据
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                // 打印数据
                System.out.println(consumerRecord);
            }
        }
    }
}