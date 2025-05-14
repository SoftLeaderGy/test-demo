package com.kafkastart.demo.demos.web.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2022/4/11 11:58
 */
/**
 * 必须知道kafka的消息只有在同一分区才能保证消费严格有序的，
 * 所以有时候我们必须吧某一批消息发往同一个分区，
 * 这时候我们可以自定义分区策略，
 * 只需要实现Partitioner接口即可
 */

/**
 * 1、实现{@link Partitioner}接口
 * 2、重写partition()方法
 */
public class MyPartitioner implements Partitioner {
    /**
     *
     * @param s 主题topic
     * @param o key
     * @param bytes key序列化后字节数组
     * @param o1 value
     * @param bytes1 value序列化后的字节数组
     * @param cluster 集群元数据信息可以查看分区
     * @return
     */
    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        // 获取消息的key，这里假设只处理key为整数的
        Integer key = Integer.valueOf(o.toString());
        // 获取topic的分区总数
        Integer count = cluster.partitionCountForTopic(s);
        return key % count;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
