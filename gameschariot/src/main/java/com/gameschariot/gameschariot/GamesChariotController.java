package com.gameschariot.gameschariot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public Greeting gamesList() throws IOException {
        // scraper
        Document doc = Jsoup.connect("https://help.netflix.com/en/node/121442").get();
        Elements listOfGames = doc.select(".c-wrapper div li a");
        System.out.println(doc.select(".c-wrapper div li a"));

        List<String> gameTitles = new ArrayList<>();
        for(Element game : listOfGames) {
            gameTitles.add(game.ownText());
        }
        // remove first 2 items and last item from list
        gameTitles.remove(0);
        gameTitles.remove(0);
        gameTitles.remove(gameTitles.size()-1);
        return new Greeting(counter.incrementAndGet(), gameTitles.toString());
    }
}
