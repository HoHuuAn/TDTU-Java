package com.model;

import com.EventInterface.EventActionUser;


public class ModelActionUser {

    private ModelUser manager;
    private EventActionUser event;

    public ModelUser getUser() {
        return manager;
    }

    public void setUser(ModelUser manager) {
        this.manager = manager;
    }

    public EventActionUser getEvent() {
        return event;
    }

    public void setEvent(EventActionUser event) {
        this.event = event;
    }

    public ModelActionUser(ModelUser manager, EventActionUser event) {
        this.manager = manager;
        this.event = event;
    }

    public ModelActionUser() {
    }
}
