package com.mayi.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;


/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 11:01 2019/12/2
 */
@RestController
public class ProducerController {



    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    /*
     * 消息生产者
     */
    @GetMapping("/sendmsg")
    public void sendmsg(String msg) {
        // 指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @GetMapping("/send")
    public void send(String msg) {
        // 指定消息发送的目的地及内容
        System.out.println("@@@@@@@@@@@@@@" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }

}
