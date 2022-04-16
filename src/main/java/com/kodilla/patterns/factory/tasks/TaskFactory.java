package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task completeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING :
                return new ShoppingTask("go shopping", "milk", 2.0);
            case PAINTING :
                return new PaintingTask("repaint bedroom", "white", "walls and ceiling");
            case DRIVING :
                return new DrivingTask("refuel", "petrol station", "car");
            default :
                return null;
        }
    }
}