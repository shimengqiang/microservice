package com.example.provider.mq;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.example.common.Hello;
import org.example.common.mq.Constant;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */

@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(String msg) {
		send(msg, "", Constant.QUEUE_1);
	}

	public void send(String msg,  String exchangeNme, String routingKeyName){
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		Hello hello = new Hello(Long.parseLong(msg), "HELLO:" + msg, date);
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (!ack) {
				System.out.println("发送mq失败: " + cause + correlationData.toString());
				//TODO 可将消息缓存起来 定时扫描 失败数据 隔段时间重发
			} else {
				System.out.println("消息发送成功,消息ID：" + (correlationData != null ? correlationData.getId() : null));
			}
		});
		//
		rabbitTemplate.setReturnCallback((message, replyCode, replyText,
				exchange, routingKey) ->{
			System.out.println(MessageFormat.format("消息发送ReturnCallback:{0},{1},{2},{3},{4},{5}",
					message.toString(), replyCode, replyText, exchange, routingKey));
		});
		// rabbitTemplate.convertAndSend(Constant.QUEUE_1,hello);
		rabbitTemplate.convertAndSend(exchangeNme, routingKeyName ,hello,
				message -> {
					message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
					return message;
				},
				new CorrelationData(hello.getId().toString()));

	}


}
