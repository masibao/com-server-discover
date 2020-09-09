package com.mayi.redis.receive;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;


/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 09:52 2020/9/9
 */
@Service
public class RedisReceive {

    public void receiveMessage(String message){
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);

        try {
            String mes = new String(message.getBytes("utf-8"));
            System.out.println(mes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        User user = (User)seria.deserialize(bytes);
        System.out.println(message);

    }
}
