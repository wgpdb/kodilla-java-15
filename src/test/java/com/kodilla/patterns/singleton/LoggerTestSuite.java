package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private Logger logger;

    @Test
    void testGetLastLog() {
        //Given
        logger = Logger.getInstance();
        logger.log("This is a log entry");

        //When
        String log = logger.getLastLog();

        //Then
        assertEquals("This is a log entry", log);
    }
}