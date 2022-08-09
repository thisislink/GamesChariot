package com.gameschariot.gameschariot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gameschariot")
public record GamesChariotConfig(String apiUrl, String databaseServer, String databaseUsername, String databasePassword) {

}
