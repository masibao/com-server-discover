package com.mayi.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 20:01 2020/6/18
 */
@Service
@Slf4j
public class CacheBaseService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object object, Long time) {
        // 让该方法能够支持多种数据类型存放
        if (object instanceof String) {
            setString(key, object);
        }
        // 如果存放时Set类型
        if (object instanceof Set) {
            setSet(key, object);
        }
        // 如果存放hash类型
        if (object instanceof Map) {
            setHash(key, object);
        }
        // 设置有效期
        if (time != null) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }

    }

    public void setString(String key, Object object) {
        if(object instanceof String){
            String value = (String) object;
            // 存放string类型
            stringRedisTemplate.opsForValue().set(key, value);
        }
    }

    public void setSet(String key, Object object) {
        Set<String> valueSet = (Set<String>) object;
        for (String string : valueSet) {
            stringRedisTemplate.opsForSet().add(key, string);
        }
    }

    public void setHash(String key, Object object) {
        log.info("##hash 存储##");
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        Map<String,Object> valueSet = (Map<String,Object>) object;
        Iterator<Map.Entry<String, Object>> iterator = valueSet.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key1 = next.getKey();
            Object value = next.getValue();
            hashOperations.put(key,key1,value);
        }
    }

    public Map<Object, Object> acquireHash(String key) {
        log.info("##获取hash 数据##");
        HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        Map<Object, Object> entries = hashOperations.entries(key);
        return entries;

    }

    public Long incr(String key){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Long increment = valueOperations.increment(key);
        return increment;

    }

    public Long decr(String key){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        Long increment = valueOperations.decrement(key);
        return increment;

    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void deleteKey(String key){
        stringRedisTemplate.delete(key);
    }

}
