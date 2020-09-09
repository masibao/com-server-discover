package com.mayi.redis.config;

import com.mayi.redis.receive.RedisReceive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Author: Neo M
 * @Desc: redis消息订阅配置类
 * @Date: Create in 09:46 2020/9/9
 */
@Configuration
public class RedisListenerConfig {

    @Bean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory,
                                                        MessageListenerAdapter adapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(adapter,new PatternTopic("xxx1"));
        container.addMessageListener(adapter,new PatternTopic("xxx2"));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RedisReceive redisReceive){
        System.out.println("消息进入适配器了>>>>");
        return new MessageListenerAdapter(redisReceive,"receiveMessage");
    }
}
