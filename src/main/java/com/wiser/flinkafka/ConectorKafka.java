/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wiser.flinkafka;

import java.util.Properties;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


/**
 *
 * @author Brenno Mello <brennodemello.bm at gmail.com>
 */
public class ConectorKafka {
    // set up the streaming execution environment
    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    // env.enableCheckpointing(5000);
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
    Properties properties = new Properties();
    properties.setProperty("bootstrap.servers", "localhost:9092");
    properties.setProperty("zookeeper.connect", "localhost:2181");
    properties.setProperty("group.id", "test");
    FlinkKafkaConsumer09<String> myConsumer = new FlinkKafkaConsumer09<> ("temp", new SimpleStringSchema(), properties);
    myConsumer.assignTimestampsAndWatermarks(new CustomWatermarkEmitter());
} 
