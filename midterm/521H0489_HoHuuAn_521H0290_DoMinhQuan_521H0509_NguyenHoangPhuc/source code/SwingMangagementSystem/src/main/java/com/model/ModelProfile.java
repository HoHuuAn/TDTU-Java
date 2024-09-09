package com.model;

import javax.swing.Icon;
// contain the class of modelProfile. The profile will tell us how to show the icon 
public class ModelProfile {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }
      public ModelProfile(Icon icon) {
        this.icon = icon;
       
    }

    public ModelProfile() {
    }

    private Icon icon;
    private String name;
}
