package com.mayi.redis.controller;

import com.mayi.redis.RedisService;
import com.mayi.redis.service.CacheBaseService;
import com.mayi.redis.utils.DistributedRedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 19:13 2020/6/4
 */
@RestController
@RequestMapping("/")
public class RedisController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private DistributedRedisLock distributedRedisLock;
    
    @Autowired
    private CacheBaseService cacheBaseService;
    
    @GetMapping("/lock")
    public String lock(){
        boolean lock = distributedRedisLock.acquire("mayi");
        return "" + lock;
    }

    @GetMapping("/release")
    public String release(){
        distributedRedisLock.release("mayi");
        return "success";
    }

    @GetMapping("/lock1")
    public String lock1(){
//        boolean lock = distributedRedisLock.acquire("mayi");
        redisService.lock();
        return "你好";
    }


    @GetMapping("/saveCache")
    public String saveCache(){
//        boolean lock = distributedRedisLock.acquire("mayi");
        distributedRedisLock.saveCache("User");
        return "缓存";
    }

    @GetMapping("/clusterRedison")
    public String lockC(){
//        boolean lock = distributedRedisLock.acquire("mayi");
        distributedRedisLock.lockC();
        return "缓存123";
    }

    @GetMapping("/cacheSave")
    public String cacheSave(){
        Map<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("id","100354");
        hashMap.put("name","张三");
        hashMap.put("age","56");
        hashMap.put("likely","足球");
//        boolean lock = distributedRedisLock.acquire("mayi");
        cacheBaseService.set("student",hashMap,100L);
        return "缓存123";
    }

    @GetMapping("/cacheAcquire")
    public String cacheAcquire(){
//        boolean lock = distributedRedisLock.acquire("mayi");
        Map<Object, Object> student = cacheBaseService.acquireHash("student");
        return student.toString();
    }

    @GetMapping("/count")
    public String count(){
//        boolean lock = distributedRedisLock.acquire("mayi");
        cacheBaseService.setString("count","0");
        Long count = cacheBaseService.decr("count");
        return "count=" + count;
    }

}
