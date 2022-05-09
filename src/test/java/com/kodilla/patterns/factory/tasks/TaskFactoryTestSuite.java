package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.kodilla.patterns.factory.tasks.TaskFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.completeTask(SHOPPING);
        shopping.executeTask();

        //Then
        assertTrue(shopping.isTaskExecuted());
        assertEquals("go shopping", shopping.getTaskName());
    }

    @Test
    void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.completeTask(PAINTING);
        painting.executeTask();

        //Then
        assertTrue(painting.isTaskExecuted());
        assertEquals("repaint bedroom", painting.getTaskName());
    }

    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.completeTask(DRIVING);
        driving.executeTask();

        //Then
        assertTrue(driving.isTaskExecuted());
        assertEquals("refuel", driving.getTaskName());
    }

    @ParameterizedTest
    @MethodSource("provideTask")
    void taskFactoryParametrizedTest(String taskName, String expected) {
        assertEquals(expected, new TaskFactory().completeTask(taskName).getTaskName());
    }

    private static Stream<Arguments> provideTask() {
        return Stream.of(
                arguments(SHOPPING, "go shopping"),
                arguments(PAINTING, "repaint bedroom"),
                arguments(DRIVING, "refuel")
        );
    }
}