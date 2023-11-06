package com.allitov.studentrecords.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHolderListener {

    @EventListener
    public void listen(SaveEventHolder eventHolder) {
        System.out.println(eventHolder.getEvent().student());
    }

    @EventListener
    public void listen(DeleteEventHolder eventHolder) {
        System.out.println("ID: " + eventHolder.getEvent().student().getId());
    }
}
