package com.msa.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@RefreshScope
@SpringBootApplication
public class GatewayApplication {

	@Value("${spring.profiles.active}")
	private String active;
	@Value("${config.gateway.http8081}")
	private String http8081;
	@Value("${config.gateway.http8082}")
	private String http8082;

	@Bean
	@RefreshScope
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		System.out.println("active: " + active);
		System.out.println(http8081 + ":" + http8082);
		return builder.routes()
				.route(p -> p
						.path("/posts/**") // /posts or /posts/{id}
						.uri("lb://posts"))
				.route(p -> p
						.path("/comments/**") // /comments or /comments/{id}
						.uri(http8082))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
