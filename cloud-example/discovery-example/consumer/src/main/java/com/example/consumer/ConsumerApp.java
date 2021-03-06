package com.example.consumer;

import com.example.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author smq
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.consumer.service")
public class ConsumerApp {
    public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApp.class, args);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    static class Controller{
        private final RestTemplate restTemplate;
        @Autowired
        public Controller(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }
        @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str) {
            return restTemplate.getForObject("http://service-provider/echo/" + str, String.class);
        }
    }
    @RestController
    static class FeignController{
        @Autowired
        private UserService userService;
        @RequestMapping(value = "/feignEcho/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str) {
            return userService.echo(str);
        }
    }

}
