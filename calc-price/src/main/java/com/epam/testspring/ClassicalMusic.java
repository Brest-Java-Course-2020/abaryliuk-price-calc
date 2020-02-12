package com.epam.testspring;

public class ClassicalMusic implements Music {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    public ClassicalMusic(String name) {
        this.name = name;
    }

    @Override
    public String playMusic() {

        return "Classical music";
    }
}
