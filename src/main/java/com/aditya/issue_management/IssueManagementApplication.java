package com.aditya.issue_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class IssueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementApplication.class, args);
	}
}
