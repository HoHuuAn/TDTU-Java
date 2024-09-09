///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package com.CustomComponent;


import java.awt.Color;
import java.awt.Graphics;

import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CustomTextField extends JTextField {

    
   private Shape shape;
    private final JButton searchButton = new JButton(); // Create a button with no text
    private boolean isFocused = false;
    private Color focusBorderColor = Color.BLUE;
    private Color shadowColor = new Color(0, 0, 0, 50); // R, G, B, Alpha 
    public CustomTextField() {
        setOpaque(false);
        setBorder(new EmptyBorder(0, 30, 0, 40));
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                isFocused = true;
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                isFocused = false;
                repaint();
            }
        });

        searchButton.setIcon(new ImageIcon(getClass().getResource("/com/ResourceImage/TextFiled_searchIcon.png"))); // Add the path to your search icon
        searchButton.setOpaque(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setBorderPainted(false);
        searchButton.addActionListener(e -> {

        });
        add(searchButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
    super.paintComponent(g);
    
    int buttonX = getWidth() - 40; 
    int buttonY = (getHeight() - searchButton.getIcon().getIconHeight()) / 2;
    searchButton.setBounds(buttonX, buttonY, searchButton.getIcon().getIconWidth(), searchButton.getIcon().getIconHeight());
     

    }

    @Override
    protected void paintBorder(Graphics g) {
          if (isFocused) {
        g.setColor(focusBorderColor);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
          }

}

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        return shape.contains(x, y);
    }
}



