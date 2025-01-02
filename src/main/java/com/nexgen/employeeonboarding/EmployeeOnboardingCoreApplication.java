package com.nexgen.employeeonboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nexgen.employeeonboarding.config")
public class EmployeeOnboardingCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeOnboardingCoreApplication.class, args);
	}

}
