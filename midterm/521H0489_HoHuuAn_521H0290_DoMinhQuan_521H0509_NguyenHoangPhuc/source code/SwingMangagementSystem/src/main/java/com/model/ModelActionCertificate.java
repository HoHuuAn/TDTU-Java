/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;



import com.EventInterface.EventActionCertificate;

public class ModelActionCertificate {

    private ModelCertificate certificate;
    private EventActionCertificate event;

    public ModelCertificate getCertificate() {
        return certificate;
    }

    public void setCertificate(ModelCertificate certificate) {
        this.certificate = certificate;
    }

    public EventActionCertificate getEvent() {
        return event;
    }

    public void setEvent(EventActionCertificate event) {
        this.event = event;
    }

    public ModelActionCertificate(ModelCertificate certificate, EventActionCertificate event) {
        this.certificate = certificate;
        this.event = event;
    }

    public ModelActionCertificate() {
    }
}
