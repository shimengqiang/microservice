package com.example.provider.mq.conf;

import org.example.common.mq.QueueName;
import org.springframework.amqp.core.Queue;
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

	/**
	 * direct
	 *
	 * @return
	 */
	@Bean
	public Queue queue(){
		return new Queue(QueueName.QUEUE_1,true);
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
