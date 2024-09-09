/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MainComponet;



import javax.swing.DefaultListModel;
import javax.swing.JList;


public class ListMenu<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int selectedIndex = -1;

    
    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
      

    }

    public void addItem(String data) {
        model.addElement(data);
    }
}