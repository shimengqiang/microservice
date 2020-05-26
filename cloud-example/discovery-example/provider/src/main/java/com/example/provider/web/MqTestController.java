package com.example.provider.web;

import com.example.provider.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smq
 */
@RestController
@RequestMapping
public class MqTestController {

	@Autowired
	private Sender sender;

	@PutMapping("/send")
	public String send(){
		for (int i = 0; i < 10; i++) {
			sender.send(i+"");
		}

		return "ok";
	}
}
