package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User john = new Millennial("John");
        User adam = new YGeneration("Adam");
        User anna = new XGeneration("Anna");

        //When
        String johnWillShareOn = john.sharePost();
        System.out.println("John will " + johnWillShareOn);

        String adamWillShareOn = adam.sharePost();
        System.out.println("Adam will " + adamWillShareOn);

        String annaWillShareOn = anna.sharePost();
        System.out.println("Anna will: " + annaWillShareOn);

        //Then
        assertEquals("share on snapchat [millennial]", johnWillShareOn);
        assertEquals("share on facebook [Y-generation]", adamWillShareOn);
        assertEquals("share on twitter [X-generation]", annaWillShareOn);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User adam = new YGeneration("Adam");

        //When
        String adamWillShareOn = adam.sharePost();
        System.out.println("Adam will " + adamWillShareOn);

        adam.setSharingStrategy(new TwitterPublisher());
        adamWillShareOn = adam.sharePost();
        System.out.println("Adam will now " + adamWillShareOn);

        //Then
        assertEquals("share on twitter [X-generation]", adamWillShareOn);
    }

    @ParameterizedTest
    @MethodSource("provideUserForSharingStrategy")
    void sharingStrategyParametrizedTest(User user, String expected) {
        assertEquals(expected, user.sharePost());
    }

    private static Stream<Arguments> provideUserForSharingStrategy() {
        return Stream.of(
                arguments(new Millennial("John"), "share on snapchat [millennial]"),
                arguments(new YGeneration("Adam"), "share on facebook [Y-generation]"),
                arguments(new XGeneration("Anna"), "share on twitter [X-generation]")
        );
    }
}