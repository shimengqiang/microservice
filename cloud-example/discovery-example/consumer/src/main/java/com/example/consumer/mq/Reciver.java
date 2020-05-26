package com.example.consumer.mq;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.example.common.Hello;
import org.example.common.mq.Constant;
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
public class Reciver {

	@Autowired
	private ConnectionFactory connectionFactory;

	@RabbitListener(queues = Constant.QUEUE_1)
	@RabbitHandler
	public void process(Hello hello, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Channel channel) throws IOException {
		System.out.println("接收QUEUE_1消息：" + hello.toString());
		channel.basicAck(deliveryTag, false);
	}
	@RabbitListener(queues = Constant.QUEUE_2)
	@RabbitHandler
	public void topicProcess(Hello hello, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Channel channel) throws IOException {
		System.out.println("接收QUEUE_2消息：" + hello.toString());
		channel.basicAck(deliveryTag, false);
	}
	@RabbitListener(queues = Constant.QUEUE_3)
	@RabbitHandler
	public void topicProcess1(Hello hello, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Channel channel) throws IOException {
		System.out.println("接收QUEUE_3收消息：" + hello.toString());
		channel.basicAck(deliveryTag, false);
	}
}
