package com.kodilla.patterns.strategy.social;

public class XGeneration extends User{

    public XGeneration(String name) {
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}