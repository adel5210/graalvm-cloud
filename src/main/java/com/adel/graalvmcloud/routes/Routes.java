package com.adel.graalvmcloud.routes;

import org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    
    @Bean
    public RouterFunction<ServerResponse> routes(){
        return RouterFunctions.route()
                    .GET("/api/**", HandlerFunctions.http("https://httpbin.org/uuid"))
                    .filter(FilterFunctions.rewritePath("/api/(?<segment>.*)", "/$\\{segment}"))
                    .build();
    }


}
