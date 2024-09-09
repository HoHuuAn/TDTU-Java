/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EventInterface;

import com.model.ModelCertificate;


public interface EventActionCertificate {

    void delete(ModelCertificate certificate);

    void update(ModelCertificate certificate);

    void view(ModelCertificate certificate);

}
