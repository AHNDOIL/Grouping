package com.AHNDOIL.Grouping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GroupingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupingApplication.class, args);
	}

}
