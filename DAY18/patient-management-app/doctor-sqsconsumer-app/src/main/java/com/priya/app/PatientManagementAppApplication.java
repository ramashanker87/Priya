package com.priya.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


@SpringBootApplication
class PatientManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementAppApplication.class, args);
	}
	@Scheduled(fixedRate = 50000)
	public void scheduledTask() {
		System.out.println("Task executed at: " + new Date());
	}
}
