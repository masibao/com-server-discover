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

public class PersistenceTopicReceiver2 {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://116.62.234.85:1616");
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("cc2");

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("MyTopic");
        TopicSubscriber consumer = session.createDurableSubscriber(destination, "t1");
        connection.start();

        Message receive = consumer.receive();
        while (receive != null){
            TextMessage textMessage = (TextMessage)receive;
            System.out.println("收到消息:" + textMessage.getText());
            receive = consumer.receive(1000L);
        }

        session.commit();
        session.close();
        connection.close();
    }
}
*/
