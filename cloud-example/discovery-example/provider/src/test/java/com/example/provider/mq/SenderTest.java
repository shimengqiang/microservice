package com.example.provider.mq;

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
}