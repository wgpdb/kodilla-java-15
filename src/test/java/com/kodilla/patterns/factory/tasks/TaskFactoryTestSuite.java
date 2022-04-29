package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.completeTask(TaskFactory.SHOPPING);
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
        Task painting = factory.completeTask(TaskFactory.PAINTING);
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
        Task driving = factory.completeTask(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        assertTrue(driving.isTaskExecuted());
        assertEquals("refuel", driving.getTaskName());
    }

    @ParameterizedTest
    @MethodSource("provideTask")
    void taskFactoryParametrizedTest(Task task, String expected) {
        assertEquals(expected, task.getTaskName());
    }

    private static Stream<Arguments> provideTask() {
        return Stream.of(
                arguments(new TaskFactory().completeTask(TaskFactory.SHOPPING), "go shopping"),
                arguments(new TaskFactory().completeTask(TaskFactory.PAINTING), "repaint bedroom"),
                arguments(new TaskFactory().completeTask(TaskFactory.DRIVING), "refuel")
        );
    }
}