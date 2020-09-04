package com.mayi.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 11:08 2019/12/2
 */
@RestController
@Slf4j
public class ConsumerTwoController {

    @JmsListener(destination = "active.topic")
    public void receiveActiveTopic(String msg){

        log.info("receive topic 2: {}",msg);
    }

}
