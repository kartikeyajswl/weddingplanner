package com.wedding.WeddingPlanner;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeddingPlannerApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(WeddingPlannerApplication.class, args);
		}
		catch (Exception e){
			System.out.println(e);
		}
		}
	}
