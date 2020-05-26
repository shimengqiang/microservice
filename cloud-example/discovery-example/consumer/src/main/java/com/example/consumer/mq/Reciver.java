package com.example.consumer.mq;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.example.common.Hello;
import org.example.common.mq.QueueName;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Component
@RabbitListener(queues = QueueName.QUEUE_1)
public class Reciver {

	@Autowired
	private ConnectionFactory connectionFactory;

	@RabbitHandler
	public void process(Hello hello, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Channel channel) throws IOException {
		System.out.println("接收消息：" + hello.toString());
		channel.basicAck(deliveryTag, false);
	}
}
