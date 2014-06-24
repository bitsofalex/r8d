package com.bits.alex.cqrs.axon;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by alexl on 18/06/2014.
 */
public class CreateToDoItemCommand {

    @TargetAggregateIdentifier
    private final String todoId;
    private final String description;

    public CreateToDoItemCommand(String todoId, String description) {
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
