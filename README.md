# GamesChariot
Scraper built to a get list of games from the Netflix [website](https://help.netflix.com/en/node/121442).

# Table of Contents

- [Purpose](https://github.com/thisislink/GamesChariot#purpose)
- [Setup](https://github.com/thisislink/GamesChariot#setup)
    * [Running the Code](https://github.com/thisislink/GamesChariot#running-the-code)
    * [Using the Website](https://github.com/thisislink/GamesChariot#using-the-website-future-state)
- [Learnings](https://github.com/thisislink/GamesChariot#learnings)
    * [Java Environment Variables](https://github.com/thisislink/GamesChariot#java-environment-variables)
    * [Spring Boot JSON Pretty Print](https://github.com/thisislink/GamesChariot#spring-boot-json-pretty-print)
    * [Spring Boot Maven Plugin POM file Error](https://github.com/thisislink/GamesChariot#spring-boot-maven-plugin-pom-file-error)
    * [ConcurrentModificationException](https://github.com/thisislink/GamesChariot#concurrentmodificationexception)
    * [JSoup CSS Selectors eq vs nth-child](https://github.com/thisislink/GamesChariot#jsoup-css-selectors-eq-vs-nth-child)
- [Improvements](https://github.com/thisislink/GamesChariot#improvements)

## Purpose
Here are some reasons I developed this project:

* I like video games.
* I find Netflix's gaming division interesting.
* Netflix does not have an API (that I could find) for their games.
* I had interest in a Netflix role tweeted out on Twitter in January 2022, but it required Java experience. [The article I wrote and the tweet that started it all](https://alwayslearningtech.com/java-practice).
* I completed a Summer 2022 Upper Division Advanced Java college course in July 2022 to help strengthen my graduate school application and earned a 4.0. The group project was to design a web application and we developed an Issue Tracker. Most of [my private GitHub contributions](https://github.com/thisislink) in July were to the Issue Tracker. This was my first Java project in a group. 
* Most of my corporate professional coding experience is in .NET (VB and C#), so the only way to learn and practice Java is outside of work.
* The Java class taught me the fundamentals of setting up a Tomcat server and using HTTP Servlets instead of using a framework. I wanted to learn how to use Spring Boot to make server setup easier and quicker.
* The Issue Tracker project exposed secret credentials publically that I normally would not have wanted pushed to GitHub. There is a concept of env files and environment variables in C# and Node. I figured there had to be a similar concept in Java. So, I wanted to learn how to keep sensitive information secure in a Java application and off GitHub. 

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

## Setup

### Running the Code

**Requirements**
* IDE - I use [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/)
* Java Version 18.0.1.1
* Node 18.7.0

Pull down the code to your local machine or fork the branch and pull down the code to your local machine.

Start the server for the backend. 

If using Intellij, you can Run the GamesChariotApplication to start the server. 

Then, click the Terminal tab and change directories to the frontend directory.

Then type and enter 'run start' to start the frontend server.

The backend server is located at localhost:8080 and the frontend server is located at localhost:3000.

The api frontend is located at localhost:3000/api.

### Using the Website (future state)

**Requirements**
* Internet Connection
* Modern web browser

In the future, you will be able to use the website in one of two ways:

1. By visiting [gameschariot.com](https://gameschariot.com) to see a current list of games offered by Netflix.
2. By visiting [gameschariot.com/api](https://gameschariot.com/api) to see the environment variables you need to configure to run the application on your local machine.

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

## Learnings

Below is a list of challenges and things I learned while building this project.

### Java Environment Variables 
I briefly mentioned in the [purpose](https://github.com/thisislink/GamesChariot#purpose) section I wanted to learn how to setup environmental variables. 

Specifically, I wanted to learn how to use them in Java so I could store database credentials. 

With the Issue Tracker project I previously worked on, I had received an email notification that the server had been used to perform brute force attacks and might be compromised.

I did not want the same fate to happen to this project.

So, other than taking other known precautions when setting up a server, such as firewall setup, I knew not disclosing usernames and passwords publically was going to be crucial.

I chose to take advantage of Java .properties files to properly hide the database and server details I wanted to hide. With the use of a configuration controller, the keys that will need to be setup for anyone using the api can be accessed from the [/api](https://gameschariot.com/api) route in a [future state](https://github.com/thisislink/GamesChariot#using-the-website-future-state). 

The resource which really helped me learn how to setup the configuration is this [Store Secrets video](https://www.youtube.com/watch?v=PmGLn3ua_lU). 

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

### Spring Boot JSON Pretty Print

This was more of a minor annoyance that I wanted to fix. The JSON object I created for the api route was displaying all of the keys and values on one line. 

I wanted the JSON to display in a standard vertical JSON format. 

I learned since I was using Spring Boot, by default it uses the Jackson JSON ObjectMapper. This meant I only needed to enable to pretty print setting in the application.properties file.

```
spring.jackson.serialization.indent_output = true
```

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

### Spring Boot Maven Plugin POM file Error

I created my Spring Boot application using the [Spring Initializr](start.spring.io), however, my pom.xml file had an error on the org.springframework.boot plugin. 

A quick Google search informed me the version tag was missing below the artifact tag.

```
<version>${project.parent.version}</version>
```

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

### ConcurrentModificationException

I learned that this error can happen when attempting to remove objects from a hashmap while iterating over a hashmap.

I was previously do this because the css selector query I was using didn't give me the exact data I needed. 

So, one solution to not have this error happen is to create a secondary collection to store the values or keys that will need to be removed.

Then, depending on the data structure being used, you can use the proper built-in list, hashmap, array, etc. method to remove the items from the original collection after the iteration is done.

I eventually figured out a better CSS selector, so I no longer needed to use the solution for this exception. 

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

### JSoup CSS Selectors eq vs nth-child

One of the challenges I had with scraping the data was creating the right CSS selector.

The original selector I used required me to manipulate the HTML in Java after I had scraped it. 

This was not ideal, because I was hardcoding some css classes and if the class names ever changes, the CSS selector would also break, and therefore break the scraper.

#### Original Selector
```
.c-wrapper div li a
```

The other challenge I was running into, was I had figured out a better selector, but I could not get it to return any data. 

The "better" CSS selector worked in Chrome Dev Tools, but it did not work when I copied it into JSOUP.

#### "Better" CSS Selector (only worked in Chrome)
```
.c-wrapper .tab.level-1:nth-child(2) li a
```

I eventually decided to go to [try.jsoup.org](try.jsoup.org) and see if I could figure out what was wrong with my CSS selector.

The try.jsoup.org demo let me know the CSS selector had parse errors, but I did not know where the parse error was exactly.

I broke apart each class of the CSS selector in the demo to see if it would return any data. 

I learned .tab returned data, but .tab-level-1 did not and neither did .tab.level-1:nth-child(2), which was the most important part of narrowing down the CSS selector to the exact data I needed.

With some more internet searches and reading the jsoup documentation, I learned the nth-child was not the correct attribute to use. 

Instead, I should be using :eq(n), where n is some number aka the number element I want to find.

The class .level-1 also seemed it might be generated later, so I removed it. 

Ultimately, the correct CSS selector for the .tab class should have been .tab:eq(1). 

#### Final Working CSS Selector
```
.tab:eq(1) li a
```

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)

## Improvements

These are a list of things I think could be improved about the app:

- Deploy app to custom domain, gameschariot.com
- Correct the formatting of the games list on the backend, so it renders correctly on the frontend
- Store game titles and game urls in database
- Create the react component keys in a better way than calling Math.random()

[Back To Top](https://github.com/thisislink/GamesChariot#table-of-contents)