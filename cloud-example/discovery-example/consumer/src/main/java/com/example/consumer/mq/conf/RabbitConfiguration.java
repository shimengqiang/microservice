package com.example.consumer.mq.conf;

import org.example.common.mq.Constant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smq
 */


@Configuration
public class RabbitConfiguration {


	/** direct ***/
	@Bean
	public Queue queueMessage(){
		return new Queue(Constant.QUEUE_2,true);
	}

	/** topic ***/
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

	/** fanout ***/

	@Bean Queue fQueueMessage1(){
		return new Queue(Constant.QUEUE_FANOUT_1,true);
	}
	@Bean Queue fQueueMessage2(){
		return new Queue(Constant.QUEUE_FANOUT_2,true);
	}
	@Bean Queue fQueueMessage3(){
		return new Queue(Constant.QUEUE_FANOUT_3,true);
	}

	@Bean FanoutExchange fanoutExchange(){
		return new FanoutExchange(Constant.FANOUT_EXCHANGE_1);
	}

	@Bean
	Binding bindingExchangeFanoutMessage1(Queue fQueueMessage1, FanoutExchange fanoutExchange){
		return BindingBuilder.bind(fQueueMessage1).to(fanoutExchange);
	}
	@Bean
	Binding bindingExchangeFanoutMessage2(Queue fQueueMessage2, FanoutExchange fanoutExchange){
		return BindingBuilder.bind(fQueueMessage2).to(fanoutExchange);
	}
	@Bean
	Binding bindingExchangeFanoutMessage3(Queue fQueueMessage3, FanoutExchange fanoutExchange){
		return BindingBuilder.bind(fQueueMessage3).to(fanoutExchange);
	}
}
