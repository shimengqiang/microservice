package com.example.apigateway.conf;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shimengqiang
 */
@Configuration
public class RoutesConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("path_route", r -> r.path("/feignEcho/**").uri("http://localhost:8060").id("service-consumer"))
            .route("path_route1", r -> r.path("/echo/**").uri("http://localhost:8060").id("service-consumer")).build();
    }
}
