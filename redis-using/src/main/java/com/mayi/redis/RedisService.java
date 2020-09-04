package com.mayi.redis;

import com.mayi.redis.annotation.RAutoLock;
import org.springframework.stereotype.Service;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 16:10 2020/6/5
 */
@Service
public class RedisService {

    @RAutoLock(localKey = "order",leaseTime = 50000)
    public void lock(){
        System.out.println("-----------");
    }
}
