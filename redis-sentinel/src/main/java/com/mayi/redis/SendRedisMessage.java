package com.mayi.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 10:02 2020/9/9
 */

@RestController
@RequestMapping("/message")
public class SendRedisMessage {

    Lock lock = new ReentrantLock();

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("send")
    public String sendMsg(){
        redisTemplate.convertAndSend("xxx1","你是大马哈1!");
        redisTemplate.convertAndSend("xxx2","你是大马哈2!");
        redisTemplate.convertAndSend("xxx3","你是大马哈3!");
        return "ok";
    }
}
