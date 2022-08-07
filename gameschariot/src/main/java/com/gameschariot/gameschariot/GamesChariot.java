package com.gameschariot.gameschariot;

public class GamesChariot {

    private final long id;
    private final String content;

    public GamesChariot(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
