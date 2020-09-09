package com.mayi.redis;

import com.mayi.redis.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 18:12 2020/9/3
 */
@RestController
@RequestMapping("/cache")
public class CacheReadWriteController {

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/write")
    public String writeCache(String content){
        boolean name = redisUtil.set("name", content);
//        String name = redisUtil.setKey();
        return "" + name;

    }

    @GetMapping("/read")
    public String readCache(){
        Object name = redisUtil.get("name");
        return name.toString();

    }


    @GetMapping("/decr")
    public String decr(){
        long name = redisUtil.decr("stoge",1);
        return "" + name;

    }

    @GetMapping("/incr")
    public String incr(){
        long name = redisUtil.incr("stoge",1);
        return "" + name;

    }
}
