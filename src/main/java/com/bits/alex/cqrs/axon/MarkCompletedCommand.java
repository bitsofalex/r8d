package com.bits.alex.cqrs.axon;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by alexl on 18/06/2014.
 */
public class MarkCompletedCommand {

    @TargetAggregateIdentifier
    private final String todoId;

    public MarkCompletedCommand(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
