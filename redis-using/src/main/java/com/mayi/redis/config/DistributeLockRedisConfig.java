package com.mayi.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.io.IOException;


@Component
@Slf4j
public class DistributeLockRedisConfig {

/*    @Bean
    public RedissonClient singleServer() throws IOException {
        // 本例子使用的是yaml格式的配置文件，读取使用Config.fromYAML，如果是Json文件，则使用Config.fromJSON
//        Config config = Config.fromYAML(RedisConfig.class.getClassLoader().getResource("redisson-config.yml"));

        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://127.0.0.1:6379");
        singleServerConfig.setPassword("123456");
        singleServerConfig.setDatabase(3);
        return Redisson.create(config);
    }*/


    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress("redis://10.6.54.39:7001", "10.6.54.39:7002", "10.6.54.44:7001",
                        "10.6.54.44:7002", "10.6.54.48:7001", "10.6.54.48:7002");


        RedissonClient redisson = Redisson.create(config);
        log.info("redis load success!");
        return redisson;
    }






}
