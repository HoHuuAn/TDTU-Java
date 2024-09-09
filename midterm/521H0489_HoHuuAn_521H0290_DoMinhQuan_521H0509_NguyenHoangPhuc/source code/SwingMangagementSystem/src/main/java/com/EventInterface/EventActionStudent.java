/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EventInterface;

import com.model.ModelStudent;


public interface EventActionStudent {
     public void delete(ModelStudent student);

    public void update(ModelStudent student);
    
    public void view(ModelStudent student);
    
}
