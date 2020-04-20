package com.example.consumer.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author smq
 */

@FeignClient(name = "service-provider")
@RibbonClient(name="service-provider")
public interface UserService {
    @GetMapping(value = "/echo/{string}")
    String echo(@PathVariable(name = "string") String string);
}
