package com.yyq.data.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class DataMongoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMongoServiceApplication.class, args);
	}
}
