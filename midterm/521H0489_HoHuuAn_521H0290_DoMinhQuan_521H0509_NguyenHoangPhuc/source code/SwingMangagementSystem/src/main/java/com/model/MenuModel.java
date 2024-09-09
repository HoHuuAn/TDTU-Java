/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import javax.swing.Icon;

/**
 *
 * @author konod
 */
public class MenuModel {
        public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

   
    public MenuModel(Icon icon, String menuName) {
        this.icon = icon;
        this.menuName = menuName;
     
    }

    public MenuModel() {
    }

    private Icon icon;
    private String menuName;
}
