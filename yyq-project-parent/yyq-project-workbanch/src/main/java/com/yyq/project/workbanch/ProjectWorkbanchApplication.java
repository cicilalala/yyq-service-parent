package com.yyq.project.workbanch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableFeignClients(basePackages = {"com.yyq.thirdparty.gaode.api"})
@EnableCircuitBreaker
public class ProjectWorkbanchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWorkbanchApplication.class, args);
	}
}
