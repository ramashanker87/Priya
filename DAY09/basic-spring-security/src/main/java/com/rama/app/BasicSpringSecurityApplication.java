package com.rama.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class BasicSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringSecurityApplication.class, args);
	}
	@Scheduled(fixedRate = 50000)
	public void scheduledTask() {
		System.out.println("Task executed at: " + new Date());
	}

}
