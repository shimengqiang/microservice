package com.example.provider.mq;

import org.example.common.mq.Constant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SenderTest extends SpringBootTestAbstract{

	@Autowired
	private Sender sender;
    @Test
    public void send() {
		for (int i = 0; i < 10; i++) {
    		sender.send(i+"");
		}
    }
    @Test
    public void send1() {
		for (int i = 0; i < 2; i++) {
    		sender.send(i+"", Constant.EXCHANGE_1, Constant.ROUTING_KEY_1);
		}
    }
    @Test
    public void send2() {
		for (int i = 0; i < 2; i++) {
    		sender.send(i+"", Constant.EXCHANGE_1, Constant.ROUTING_KEY_3);
		}
    }
}