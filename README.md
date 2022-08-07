# GamesChariot
Scraper built to a get list of games from the Netflix [website](https://help.netflix.com/en/node/121442).

# Table of Contents

- Purpose
- Setup
    * Running the Code
    * Using the Website
- Learnings
    * Java Environment Variables 
    * Spring Boot JSON Pretty Print
    * Spring Boot Maven Plugin POM file Error
    * ConcurrentModificationException
    * JSoup CSS Selectors eq vs nth-child

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

## Setup

### Running the Code

**Requirements**
* IDE - I use [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/)
* Java Version 18.0.1.1
* Node 18.7.0

### Using the Website

**Requirements**
* Internet Connection
* Modern web browser

You can use the website currently in one of two ways:

1. You can visit [gameschariot.com](https://gameschariot.com) and see the current list of games offered by Netflix.
2. You can visit [gameschariot.com/api](https://gameschariot.com/api) to see the environment variables you need to configure to run the application on your local machine.