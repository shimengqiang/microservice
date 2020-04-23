package com.example.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smq
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApp.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :"+userName+"; age: "+userAge);

    }
    @RestController
    class EchoController {
        @Autowired
        private Environment environment;

        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            String port = environment.getProperty("local.server.port");
            return "Hello Nacos Discovery " + string + port;
        }
    }

}
