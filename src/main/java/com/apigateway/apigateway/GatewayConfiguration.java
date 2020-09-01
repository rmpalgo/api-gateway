package com.apigateway.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTags.uri;

@EnableHystrix
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route(p -> p
                            .path("/all")
                            .filters(f -> f.addRequestHeader("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                                            .addRequestHeader(	"x-rapidapi-key", "00ef74d087mshaefe9522e030026p159d49jsn5af7baf07142"))
                            .uri("https://restcountries-v1.p.rapidapi.com")
        )
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80")).
                        build();
    }

}
