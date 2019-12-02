package com.mayi.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@RequestMapping("/mq")
public class QueueReciiverController {


    @GetMapping("/receiver")
    public String send() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://116.62.234.85:1616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 50; i++) {


            //创建消息
            TextMessage textMessage = session.createTextMessage("我是第 "+i +"调msg");
            producer.send(textMessage);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
        session.commit();
        session.close();
        connection.close();
        return "success";

    }


    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://116.62.234.85:1616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 50; i++) {


            //创建消息
            TextMessage textMessage = session.createTextMessage("我是第 "+i +"调msg");
            producer.send(textMessage);

        }
        session.commit();
        session.close();
        connection.close();
    }



}
