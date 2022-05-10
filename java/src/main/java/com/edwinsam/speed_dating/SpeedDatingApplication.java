package com.edwinsam.speed_dating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpeedDatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeedDatingApplication.class, args);
	}

}
