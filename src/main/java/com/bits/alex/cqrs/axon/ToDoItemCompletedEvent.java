package com.bits.alex.cqrs.axon;

/**
 * Created by alexl on 18/06/2014.
 */
public class ToDoItemCompletedEvent {

    private final String todoId;

    public ToDoItemCompletedEvent(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
