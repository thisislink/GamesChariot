package com.gameschariot.gameschariot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GamesChariotConfigController {
    private final GamesChariotConfig gamesChariotConfig;

    public GamesChariotConfigController(GamesChariotConfig gamesChariotConfig) {
        this.gamesChariotConfig = gamesChariotConfig;
    }

    @GetMapping
    public Map<String, String> displayConfigProperties() {
        Map<String, String> prettyJson = new HashMap<>();
        return Map.of(
                "apiUrl", gamesChariotConfig.apiUrl(),
                "databaseServer", gamesChariotConfig.databaseServer(),
                "databaseUsername", gamesChariotConfig.databaseUsername(),
                "databasePassword", gamesChariotConfig.databasePassword()
        );
    }
}