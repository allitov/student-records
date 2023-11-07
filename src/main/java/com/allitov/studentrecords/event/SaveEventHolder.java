package com.allitov.studentrecords.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SaveEventHolder extends ApplicationEvent {

    private final Event event;

    public SaveEventHolder(Object source, Event event) {
        super(source);
        this.event = event;
    }
}
