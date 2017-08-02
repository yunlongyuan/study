package com.test.helloworld;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/7/19.
 */
public class Reviever {
    public static void main(String[] args) throws Exception{
        //建立ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        //通过Factory获取connection并开启
        Connection connection=connectionFactory.createConnection();
        connection.start();
        //通过connection开启session会话
        Session session=connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        //通过Session创建Destination对象
        Destination destination=session.createQueue("hello world");
        //通过session创建消息的接受者
        MessageConsumer messageConsumer=session.createConsumer(destination);
        while(true){
            TextMessage msg=(TextMessage) messageConsumer.receive();
            if(msg==null) break;
            System.out.println("接收到的内容 " + msg.getText());
        }
        if(connection!=null){
            connection.close();
        }
    }
}
