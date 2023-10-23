package com.techbridge.sams.club;

import com.techbridge.sams.club.menuItem.MenuItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CoffeeOrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeOrderingSystemApplication.class, args);
	}



}
