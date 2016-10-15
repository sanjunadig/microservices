package com.example;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

@CrossOrigin

@EnableEurekaClient
@EnableZuulProxy
public class SearchEurekaApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchEurekaApiGatewayApplication.class, args);
	}
}
