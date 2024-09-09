package com.SwingTable;

import com.model.ModelProfile;

public class Profile extends javax.swing.JPanel {
    
    public Profile(ModelProfile data) {
        initComponents();
        pic.setIcon(data.getIcon());
        setOpaque(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new com.CustomizeUIComponent.ImageAvatar();

        setPreferredSize(new java.awt.Dimension(34, 34));
        setLayout(new java.awt.BorderLayout());
        add(pic, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.CustomizeUIComponent.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
