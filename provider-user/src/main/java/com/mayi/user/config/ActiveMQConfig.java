package com.mayi.user.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 12:24 2019/12/2
 */
@Configuration
public class ActiveMQConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("active.queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("active.topic");
    }
}
