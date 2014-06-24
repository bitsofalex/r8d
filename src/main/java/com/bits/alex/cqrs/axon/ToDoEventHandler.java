package com.bits.alex.cqrs.axon;

import org.axonframework.eventhandling.annotation.EventHandler;

/**
 * Created by alexl on 18/06/2014.
 */
public class ToDoEventHandler {

    @EventHandler
    public void handle(ToDoItemCreatedEvent event) {
        System.out.println("We've got something to do: " + event.getDescription() + " (" + event.getTodoId() + ")");
    }

    @EventHandler
    public void handle(ToDoItemCompletedEvent event) {
        System.out.println("We've completed a task: " + event.getTodoId());
    }
}
