# log4j-kafka
提供一个将标准log4j日志输出到kafka的工具。

客户端配置：

##log4j.properties

#####kafka topic名称
log4j.appender.kafka.topic=log4jtest
#####kafka broker地址
log4j.appender.kafka.brokerList=Hadoop2-302E9-1-5:9092,Hadoop3-302E9-1-6:9092

###配置完成后，调用com.opensure.test.Main进行测试。
