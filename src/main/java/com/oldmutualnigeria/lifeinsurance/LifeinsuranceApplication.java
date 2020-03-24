package com.oldmutualnigeria.lifeinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = "com.oldmutualnigeria.lifeinsurance.model")
public class LifeinsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeinsuranceApplication.class, args);
	}

}
