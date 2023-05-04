//This line declares the package that this class belongs to
package com.last.feign;

//These are the import statements for required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//This annotation marks the class as a Spring Boot application
@SpringBootApplication
//This annotation enables the use of Feign clients
@EnableFeignClients
//This is the class definition
@EnableDiscoveryClient
public class FeignClientApplication {
	
	// This is the main method, which is the entry point of the application
	public static void main(String[] args) {
		// This line starts the Spring Boot application
		SpringApplication.run(FeignClientApplication.class, args);
	}

}



