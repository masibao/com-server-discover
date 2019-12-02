package com.mayi.user.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 11:08 2019/12/2
 */
@RestController
public class ConsumerTwoController {

    @JmsListener(destination = "active.topic")
    public void receiveActiveTopic(String msg){

        System.out.println("接收到二: " + msg);
    }

}
