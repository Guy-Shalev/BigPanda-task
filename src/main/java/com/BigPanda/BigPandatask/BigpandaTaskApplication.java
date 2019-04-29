package com.BigPanda.BigPandatask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BigpandaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigpandaTaskApplication.class, args);
	}

}
