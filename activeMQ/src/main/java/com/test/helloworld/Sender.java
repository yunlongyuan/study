package com.test.helloworld;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/7/19.
 */
public class Sender {

    public static void main(String[] args) throws Exception {
        //建立ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
        //通过Factory获取connection并开启
        Connection connection=connectionFactory.createConnection();
        connection.start();
        //通过connection开启session会话
        //Session session=connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
        //使用事物的方式
        Session session=connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        //通过Session创建Destination对象
        Destination destination=session.createQueue("hello world");
        //通过session创建消息的发送者和接受者
        MessageProducer messageProducer=session.createProducer(destination);
        //设置生产者持久化的特性
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        //创建数据对象
        TextMessage textMessage=session.createTextMessage("hello world");
        //发送消息
        messageProducer.send(textMessage);
        //使用事物提交
        session.commit();
        if(connection!=null){
            connection.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
