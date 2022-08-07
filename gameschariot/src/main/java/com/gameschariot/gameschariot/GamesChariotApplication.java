package com.gameschariot.gameschariot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(GamesChariotConfig.class)
public class GamesChariotApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GamesChariotApplication.class, args);
	}
}

