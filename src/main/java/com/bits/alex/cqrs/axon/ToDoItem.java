package com.bits.alex.cqrs.axon;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by alexl on 18/06/2014.
 */
public class ToDoItem extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(CreateToDoItemCommand command) {
        apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
    }

    @EventHandler
    public void on(ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
    }
}
