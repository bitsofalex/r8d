package com.bits.alex.cqrs.axon;

/**
 * Created by alexl on 18/06/2014.
 */
public class ToDoItemCreatedEvent {

    private final String todoId;
    private final String description;

    public ToDoItemCreatedEvent(String todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }
}