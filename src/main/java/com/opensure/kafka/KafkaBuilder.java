package com.opensure.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by sure on 2015/2/9.
 */
public class KafkaBuilder {
    Producer<String, String> producer = null;
    private String topic;
    public KafkaBuilder(String topic, String brokerList) {
        this.topic = topic;
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", brokerList);
        ProducerConfig config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);
    }

    public void produce(String message) {
        String partitionKey = System.currentTimeMillis() % 5 == 0 ? "1" : "2";
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, partitionKey, message);
        producer.send(data);
    }

    public void close() {
        if(producer != null)
            producer.close();
    }

    /*public static void main(String[] args) {
        KafkaBuilder kafkaBuilder = new KafkaBuilder("log4jtest", "Hadoop2-302E9-1-5:9092,Hadoop3-302E9-1-6:9092");
        kafkaBuilder.produce("hello");
        kafkaBuilder.close();
    }*/
}
