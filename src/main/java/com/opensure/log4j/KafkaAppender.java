package com.opensure.log4j;

import com.opensure.kafka.KafkaBuilder;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by sure on 2015/2/9.
 */
public class KafkaAppender extends AppenderSkeleton {

    private String topic;
    private String brokerList;
    private KafkaBuilder kafkaBuilder = null;

     @Override
    public void activateOptions() {
        if(kafkaBuilder == null)
            kafkaBuilder = new KafkaBuilder(topic, brokerList);
    }

    @Override
    protected void append(LoggingEvent event) {
        kafkaBuilder.produce(layout.format(event));
    }

    @Override
    public void close() {
        kafkaBuilder.close();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }
}