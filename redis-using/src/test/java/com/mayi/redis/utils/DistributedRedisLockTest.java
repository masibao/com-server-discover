package com.mayi.redis.utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 19:17 2020/6/4
 */
@SpringBootTest
public class DistributedRedisLockTest {

    @Autowired
    private DistributedRedisLock distributedRedisLock;
    @Test
    public void acquire() {
        boolean lock = distributedRedisLock.acquire("mayi");
        System.out.println(lock);
    }

    @Test
    public void release() {
    }
}
