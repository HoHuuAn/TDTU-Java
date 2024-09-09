/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CustomComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Icon;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class IconTextField extends JTextField {
    private boolean isFocused = false;
    private final Color focusBorderColor = Color.BLUE;
    public IconTextField()
    {   
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
       
      
    }
    @Override 
    protected void paintComponent(Graphics g) {
   g.setColor(getBackground());
   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15,15);
   super.paintComponent(g);
  


//        if (isFocusOwner()) {
//            g.setColor(new Color(4, 88, 167));
//        } else {
//            g.setColor(new Color(142, 142, 142));
//        }
//        
        paintIcon(g);
//        //  paint border
//        if (isFocusOwner()) {
//            g.setColor(new Color(4, 88, 167));
//            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
//            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
//        } else {
//            g.setColor(new Color(142, 142, 142));
//            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
//            g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
//        }
     

    }
       @Override
   protected void paintBorder(Graphics g) {
   g.setColor(getForeground());
   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15,15);
   
    if (isFocused) {
        g.setColor(focusBorderColor);
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
          }
}
   
     public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }

    private Icon prefixIcon;
    private Icon suffixIcon;
    
    
    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 3, y, this);
        }
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - 3, y, this);
        }
    }
    private void initBorder() {
       int left = 5;
        int right = 5;
        //  5 is default
        if (prefixIcon != null) {
            //  prefix is left
            left = prefixIcon.getIconWidth() + 5;
        }
        if (suffixIcon != null) {
            //  suffix is right
            right = suffixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}
