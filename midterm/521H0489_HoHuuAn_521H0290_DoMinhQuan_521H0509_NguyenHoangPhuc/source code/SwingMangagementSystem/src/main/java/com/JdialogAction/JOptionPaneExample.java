/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JdialogAction;

import java.awt.*;
import javax.swing.*;


public class JOptionPaneExample {

    private void displayGUI() {
        JOptionPane.showConfirmDialog(
                        getPanel(),
                        "JOptionPane Example : ");
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("JavaTechnology Dive Log");
        ImageIcon image = null;
        panel.setBackground(Color.black);
//        try {
//           
//        } catch(MalformedURLException mue) {
//            mue.printStackTrace();
//        } catch(IOException ioe) {
//            ioe.printStackTrace();
//        }
        panel.add(label);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JOptionPaneExample().displayGUI();
            }
        });
    }
}