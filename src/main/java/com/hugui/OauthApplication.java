package com.hugui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuGui
 * @class com.hugui OauthApplication.java
 * @date 2018年6月24日
 */


@SpringBootApplication
@EnableDiscoveryClient
public class OauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
	
}
