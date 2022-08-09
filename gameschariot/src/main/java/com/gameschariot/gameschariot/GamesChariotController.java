package com.gameschariot.gameschariot;

import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GamesChariotController {
    @GetMapping("/")
    public GamesChariot gamesList() throws IOException {
        // scraper
        Document doc = Jsoup.connect("https://help.netflix.com/en/node/121442").get();
        Elements listOfGames = doc.select(".tab:eq(1) li a");

        HashMap<String, String> allGames = new LinkedHashMap<>();
        for(Element game : listOfGames) {
            allGames.put(game.text(), game.attr("abs:href"));
        }

        return new GamesChariot(allGames.toString());
    }
}
