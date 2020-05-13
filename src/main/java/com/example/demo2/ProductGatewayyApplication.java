package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableResourceServer
@RestController
public class ProductGatewayyApplication {

	@Autowired
	OAuth2RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductGatewayyApplication.class, args);
	}
	
	 @Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
	   
	 
	   @RequestMapping(value = "/products")
	   public String getProductName() {
		   
		   String product = restTemplate.getForObject("https://localhost:8081/product",String.class);
		  
		  
		   
	      return product;   
	   }
	}

