package com.mayi.compilimazk.config;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Neo M
 * @Desc:
 * @Date: Create in 17:17 2020/6/24
 */
@Component
public class ZookeeperConfig {

    @Value("${zk.address}")
    private String address;

    @Bean
    public ZkClient getZkBean(){
        ZkClient zkClient = new ZkClient(address,1500);
        System.out.println("已连接ZK集群:" + address);
        return zkClient;
    }
}
