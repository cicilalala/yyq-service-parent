package com.yyq.project.workbanch;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Principal;

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
