package com.kodilla.patterns.strategy.social;

public class Millennial extends User {

    public Millennial(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}