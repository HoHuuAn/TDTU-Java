/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.MainComponet;

import com.ActionPanel.*;

import java.awt.Color;

import main.Login;
import net.miginfocom.swing.MigLayout;
import com.EventInterface.EventMenuItemSelected;
import com.model.ModelUser;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;

/**
 *
 * @author konod
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    private MigLayout layout;
    private  Animator  animator ; 
    private  mainPanel  mainPanel ;
    private final ModelUser LoginUser ;
    public MainFrame(ModelUser LoginUser) {
         
        this.LoginUser =LoginUser ; 

        initComponents();
        init();
        
        
    }
//    private void showForm(JPanel form) {
//         System.out.println("Showing form: " + form.getClass().getSimpleName());
//    mainPanel.removeAll();
//    mainPanel.add(form, BorderLayout.CENTER);
//    mainPanel.revalidate();
//    mainPanel.repaint();
//}
    
 private void init() {
    header = new header(LoginUser);
    // Set transparent white color
    Color transparentWhite = new Color(242,242,242, 128);
    background.setBackground(transparentWhite);

    // Create MigLayout with specific constraints
    layout = new MigLayout("fill", "[]10[100%, fill]10", "5[fill, top]5");
    background.setLayout(layout);

    // Initialize mainPanel
    mainPanel = new mainPanel();
    mainPanel.setLayout(new BorderLayout());
    // Set event for menu selection in sideBar
    sideBar.setEventSelect(new EventMenuItemSelected() {
        @Override
        public void menuSelected(int menuIndex) {
            mainPanel.removeAll();
            // Handle menu selection based on index
            switch (menuIndex) {
                case 0:
                    // Show HomePanel when menu item 0 is selected
                    mainPanel.add(new HomePanel(), BorderLayout.CENTER);
                    
                    break;
                case 1:
                    // Show UserPanel when menu item 1 is selected
                    mainPanel.add(new StudentPanel(LoginUser), BorderLayout.CENTER);
                    break;
                case 2:

                    mainPanel.add(new UserPanel(LoginUser), BorderLayout.CENTER);
                    break;

                // Add more cases for other menu items as needed
                default:
                    // Handle cases that are not explicitly defined
                    break;
            }
        mainPanel.revalidate();
        mainPanel.repaint();
        }
    });



        // set the user of the system 
        String roleString = (LoginUser.getUserRole() == 0) ? "Manager" : (LoginUser.getUserRole() == 1) ? "Employee" : (LoginUser.getUserRole() == 2) ? "Admin" : "Unknown";
      
        sideBar.setLabel(roleString);
        if(LoginUser.getUserRole() == 2)
        {
            sideBar.AdminRole(); 
        }

        sideBar.initMenuItem();
      
        background.add(sideBar, "w 230!, spany 2");    // Span Y 2cell
        
        background.add(header, "h 50, wrap 2");
        background.add(mainPanel, "w 90%, h 90%");
        
         mainPanel.showForm(new HomePanel());
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (sideBar.isShowMenu()) {
                    width = 80 + (170 * (1f - fraction));
                } else {
                    width = 80 + (170 * fraction);
                }
                layout.setComponentConstraints(sideBar, "w " + width + "!, spany2");
                sideBar.revalidate();
            }

            @Override
            public void end() {
                sideBar.setShowMenu(!sideBar.isShowMenu());
//                sideBar.setShowMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        
        
        // pass in the action interface to the menu 
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
               
            
            }
        });

     header.addLogoutEvent(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             // Show a confirmation dialog
             int choice = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

             // Check the user's choice
             if (choice == JOptionPane.YES_OPTION) {
                 // If yes, show the login frame
                 java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                         new Login().setVisible(true);
                     }
                 });

                 // Additional code for logout, if needed

                 // Close the current frame (assuming it's the MainFrame)
                 dispose();
             }
             // If no, do nothing
         }
     });
        // set the side bar text and the header text of the application 
      

        
    }
                
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new com.MainComponet.SideBar();
        homePanel1 = new com.ActionPanel.HomePanel();
        background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(245, 245, 245));
        background.setOpaque(false);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(new ModelUser(40 , "admin", "admin", "\\src\\com\\Icon\\ZgGN0upg.png", 25 ,"1234567890",0,2)).setVisible(true);
            }
        });
    }

    private  com.MainComponet.header header ; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private com.ActionPanel.HomePanel homePanel1;
    private com.MainComponet.SideBar sideBar;
    // End of variables declaration//GEN-END:variables
}
