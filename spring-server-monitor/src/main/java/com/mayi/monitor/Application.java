package com.mayi.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	/**
	 * 健康监测
	 * http://localhost:8088/actuator/info
	 * http://localhost:8088/actuator/health
	 * http://localhost:8088/actuator/beans
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
