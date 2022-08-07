package com.gameschariot.gameschariot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return Map.of(
                "apiUrl", gamesChariotConfig.apiUrl()
        );
    }
}
