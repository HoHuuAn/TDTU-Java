package com.model;


import com.EventInterface.EventActionStudent;

// contain the student and what should the event be doing with the action 


public class ModelActionStudent {

    private ModelStudent student;
    private EventActionStudent event;

    public ModelStudent getStudent() {
        return student;
    }

    public void setStudent(ModelStudent student) {
        this.student = student;
    }

    public EventActionStudent getEvent() {
        return event;
    }

    public void setEvent(EventActionStudent event) {
        this.event = event;
    }

    public ModelActionStudent(ModelStudent student, EventActionStudent event) {
        this.student = student;
        this.event = event;
    }

    public ModelActionStudent() {
    }
}
