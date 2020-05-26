package com.example.consumer.mq.conf;

import org.example.common.mq.QueueName;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
