package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}