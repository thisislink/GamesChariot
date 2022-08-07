package com.gameschariot.gameschariot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class GamesChariotApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GamesChariotApplication.class, args);
		// scraper
		Document doc = Jsoup.connect("https://help.netflix.com/en/node/121442").get();
		Elements listOfGames = doc.select("div[class=\"tab level-1 open\"] > div[class=\"tab-content\"] > div[class=\"c-wrapper\"] > div > ul > li > p > a[href]");

		for(Element game : listOfGames) {
			System.out.println(game.text());
		}
	}
}

