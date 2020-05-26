package com.example.provider.mq.conf;

import org.example.common.mq.Constant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author smq
 */


@Configuration
public class RabbitConfiguration {

	@Bean
	public Queue queueMessage(){
		return new Queue(Constant.QUEUE_2,true);
	}
	@Bean
	public Queue queueMessages(){
		return new Queue(Constant.QUEUE_3,true);
	}

	@Bean
	TopicExchange exchange(){
		return new TopicExchange(Constant.EXCHANGE_1);
	}

	@Bean Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with(Constant.ROUTING_KEY_1);
	}
	@Bean Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with(Constant.ROUTING_KEY_2);
	}

	@Bean
	@Scope("prototype")
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		//开启强制委托模式
		template.setMandatory(true);
		template.setMessageConverter(new SerializerMessageConverter());
		return template;
	}
}
