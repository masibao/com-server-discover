package com.mayi.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "")
public class RedisSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisSentinelApplication.class, args);
	}

}
