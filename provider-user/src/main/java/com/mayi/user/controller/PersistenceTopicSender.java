/*
package com.mayi.user.controller;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

*/
/**
 * @Classname com-server-discover
 * @Author: Tony
 * @Description:
 * @Date: Create in 13:42 2019/11/30
 *//*

public class PersistenceTopicSender {


    public static void main(String[] args) throws JMSException {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://116.62.234.85:1616");
        Connection connection = activeMQConnectionFactory.createConnection();


        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("MyTopic");
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for (int i = 0; i < 10; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("我是第 "+i +"调msg");
            producer.send(textMessage);

        }
        session.commit();
        session.close();
        connection.close();
    }
}
*/
