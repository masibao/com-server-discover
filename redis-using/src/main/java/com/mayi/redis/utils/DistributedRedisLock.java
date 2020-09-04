package com.mayi.redis.utils;

import jodd.util.RandomString;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 19:11 2020/6/4
 */
@Service
public class DistributedRedisLock {
    @Autowired
    private RedissonClient redisson1;

    @Autowired
    private RedissonClient redisson2;

    @Autowired
    private RedissonClient redisson3;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String LOCK_TITLE = "redisLock_";
    //加锁
    public boolean acquire(String lockName){

        //声明key对象
        String key = LOCK_TITLE + lockName;
        //获取锁对象
        RLock lock = redisson1.getLock(key);
        //加锁，并且设置锁过期时间，防止死锁的产生
        lock.lock(2, TimeUnit.MINUTES);
        System.err.println("======lock======"+Thread.currentThread().getName());
        //加锁成功
        return  true;
    }
    //锁的释放
    public void release(String lockName){
        //必须是和加锁时的同一个key
        String key = LOCK_TITLE + lockName;
        //获取所对象
        RLock mylock = redisson1.getLock(key);
        //释放锁（解锁）
        mylock.unlock();
        System.err.println("======unlock======"+Thread.currentThread().getName());
    }


    public void saveCache(String key){
        HashOperations<String, String, String> hash = redisTemplate.opsForHash();
        hash.put(key, "name","zhangsan" + RandomString.get());

    }

    public void lockC() {
        String key = "lock_redison";
        RLock lock1 = redisson1.getLock(key);
        RLock lock2 = redisson2.getLock(key);
        RLock lock3 = redisson3.getLock(key);
        RedissonRedLock lock = new RedissonRedLock(lock1, lock2, lock3);
        lock.lock(40,TimeUnit.SECONDS);


    }
}
