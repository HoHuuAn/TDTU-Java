/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.JdialogAction;

import com.Dao.UserDao;
import com.model.ModelUser;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;



public class InputDialog extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    private ModelUser user = null ; 
    private String relativePath ; 
    public InputDialog(java.awt.Frame parent, boolean modal) {
        
        super(parent,modal);
        
        initComponents();
        init();
        setModalityType(ModalityType.APPLICATION_MODAL);
   


    }

    public InputDialog(java.awt.Frame parent, boolean modal , ModelUser user) {
       super(parent,modal);
      this.user = user ; 
    initComponents();
     init();
    setModalityType(ModalityType.APPLICATION_MODAL);
  

      
    }
    private void init() {
        PlainDocument phoneDocument = new PlainDocument();

// set the contraint on the phone textflied 
phoneDocument.setDocumentFilter(new DocumentFilter() {
 private boolean allowSetText = true;

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {
        if (isValidInsertion(text, fb, offset)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        if (isValidReplacement(text, fb, offset, length)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isValidInsertion(String text, DocumentFilter.FilterBypass fb, int offset) {
        // Allow setText to bypass the filter only once
        if (allowSetText) {
            allowSetText = false; // Disallow setText after the first time
            return true;
        }

        // Allow only digits and '+' and ensure total length is less than or equal to 10
        return (text.matches("[\\d+]") && (fb.getDocument().getLength() + text.length()) <= 10);
    }

    private boolean isValidReplacement(String text, DocumentFilter.FilterBypass fb, int offset, int length) {
        // Allow setText to bypass the filter only once
        if (allowSetText) {
            allowSetText = false; // Disallow setText after the first time
            return true;
        }

        // Allow only digits and '+' and ensure total length is less than or equal to 10
        return (text.matches("[\\d+]") && (fb.getDocument().getLength() - length + text.length()) <= 10);
    }
});

// Set the document to the IconTextField
        PhoneTextFlied.setDocument(phoneDocument);  
           ImageIcon icon;
      if (user != null && user.getProfilePicture() != null) {
        icon = new ImageIcon(user.getProfilePicture());
        String filename = user.getProfilePicture();
        this.relativePath =  filename.substring(filename.indexOf(File.separator+"src" + File.separator+ "main"+File.separator  +"resources"+ File.separator + "com" + File.separator + "Icon")) ;
    } else {
         this.relativePath = File.separator+"src"+File.separator + "main"+File.separator  +"resources"+ File.separator + "com" + File.separator + "Icon" + File.separator + "DefaultUserImage.png";

        icon = new ImageIcon( System.getProperty("user.dir") +this.relativePath);
    }

    imageAvatar1.setIcon(icon);

     
    if (user != null) {
        UsernameTextFlied.setText(user.getUserName());
        PasswordTextFlied.setText(user.getPassword());
        AgeSpinnerBlock.setValue(user.getAge());
        PhoneTextFlied.setText(user.getPhoneNumber());
      

        int statusIndex = user.getStatus();
    // set index of combobox 
    if (statusIndex >= 0 && statusIndex < StatusCombobox.getItemCount()) {
        StatusCombobox.setSelectedIndex(statusIndex);
    }

    int roleIndex = user.getUserRole();
    if (roleIndex >= 0 && roleIndex < UserRoleCombobox.getItemCount()) {
        UserRoleCombobox.setSelectedIndex(roleIndex);
    }
        // Set other fields...
    }
       
    }
    private static String saveImage(File sourceFile) {
    String destinationFileName = "";

    try {
        String fileName = sourceFile.getName();
        String fileExtension = "";

        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            fileExtension = fileName.substring(dotIndex + 1).toLowerCase();
        }

        BufferedImage image = ImageIO.read(sourceFile);
        String srcDirectory = System.getProperty("user.dir") + File.separator + "src"+File.separator + "main"+File.separator  +"resources" ;
        String packagePath = "com" + File.separator + "Icon";

        // Create the destination directory if it doesn't exist
        File directory = new File(srcDirectory, packagePath);
      

        // Specify the file name for the saved image
        String ext = "jpg"; // Default to JPEG
        if ("png".equals(fileExtension)) {
            ext = "png";
        } else if ("jfif".equals(fileExtension)) {
            ext = "jpg";
        }

        destinationFileName = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);

        // Create the destination file in the specified directory
        File destinationFile = new File(directory, destinationFileName);
     
        // Write the image to the destination file
        ImageIO.write(image, ext, destinationFile);

        // Get the relative path to the saved image
        String imagePath = srcDirectory +File.separator+ packagePath + File.separator + destinationFileName; 
        return imagePath;
    } catch (IOException ex) {
        
    }

    return "";
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordTextFlied = new com.CustomComponent.IconTextField();
        UsernameTextFlied = new com.CustomComponent.IconTextField();
        PhoneTextFlied = new com.CustomComponent.IconTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imageAvatar1 = new com.CustomizeUIComponent.ImageAvatar();
        SubmitButton = new javax.swing.JButton();
        AgeSpinnerBlock = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        StatusCombobox = new javax.swing.JComboBox<>();
        UserRoleCombobox = new javax.swing.JComboBox<>();
        ErrorTextFlied = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PasswordTextFlied.setPreferredSize(new java.awt.Dimension(200, 30));
        PasswordTextFlied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTextFliedActionPerformed(evt);
            }
        });

        UsernameTextFlied.setPreferredSize(new java.awt.Dimension(200, 30));

        PhoneTextFlied.setPreferredSize(new java.awt.Dimension(200, 30));
        PhoneTextFlied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTextFliedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("UserName ");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Password ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Status ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("PhoneNumber ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Age");

        imageAvatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        SubmitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SubmitButton.setForeground(new java.awt.Color(51, 255, 255));
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("UserRole ");

        StatusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Block" }));

        UserRoleCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Employee" }));

        ErrorTextFlied.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ErrorTextFlied.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(StatusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(UserRoleCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(UsernameTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PasswordTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(165, 165, 165))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(114, 114, 114))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(PhoneTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AgeSpinnerBlock))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(ErrorTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameTextFlied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhoneTextFlied, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AgeSpinnerBlock))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserRoleCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(ErrorTextFlied, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PhoneTextFliedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTextFliedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTextFliedActionPerformed

    private void PasswordTextFliedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTextFliedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTextFliedActionPerformed

    private boolean usernameExists(String username, UserDao userDao) {
        List<ModelUser> allUsers = userDao.getAllUsers();

        // Check if the username already exists in the list of users
        return allUsers.stream().anyMatch(user -> user.getUserName().equals(username));
    }
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        String username = UsernameTextFlied.getText().trim();
        String password = PasswordTextFlied.getText().trim();
        String phone = PhoneTextFlied.getText().trim();
        String ageText = AgeSpinnerBlock.getValue().toString().trim();
    int statusIndex = StatusCombobox.getSelectedIndex();
    int userRoleIndex = UserRoleCombobox.getSelectedIndex();


    try {
        int age = Integer.parseInt(ageText);

        if (username.isEmpty() || password.isEmpty() || phone.isEmpty() ) {
            // Display an error message if any field is empty
            ErrorTextFlied.setText("All fields must be filled");
        } else if (age <= 0 || age > 150) {
            // Display an error message if age is not in the correct range
            ErrorTextFlied.setText("Invalid age");
        } else {
            
             UserDao userDao = new UserDao(); // Instantiate your UserDao
            if (usernameExists(username,userDao) && user==null) {
                ErrorTextFlied.setText("Username already exists");
                return;
            }

            if (user == null) {
                // User is null, add a new user
                userDao.addUser(username, password, this.relativePath, age, phone, statusIndex, userRoleIndex);
            } else {
                // User is not null, update the existing user
                userDao.updateUser(user.getUserID(), username, password, this.relativePath, age, phone, statusIndex, userRoleIndex);
            }

            this.dispose();
        }
    } catch (NumberFormatException e) {
        // Display an error message if the age is not a valid number
        ErrorTextFlied.setText("Invalid age");
    }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void imageAvatar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(InputDialog.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            
            // Load and display the selected image
            File selectedFile = fileChooser.getSelectedFile();
                String filename = saveImage(selectedFile);
                this.relativePath = filename.substring(filename.indexOf(File.separator+"src"+File.separator + "main"+File.separator  +"resources"+ File.separator + "com" + File.separator + "Icon"));
               

                // Load the saved image using the absolute file path
               
            
            try {
                // Read the image using ImageIO
                ImageIcon imageIcon = new ImageIcon(ImageIO.read(selectedFile));
                imageAvatar1.setIcon(imageIcon);
                pack();

                // You can add code here to save the selected image or perform other actions
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_imageAvatar1MouseClicked
  

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
            java.util.logging.Logger.getLogger(InputDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
                
                InputDialog dialog = new InputDialog(null, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AgeSpinnerBlock;
    private javax.swing.JLabel ErrorTextFlied;
    private com.CustomComponent.IconTextField PasswordTextFlied;
    private com.CustomComponent.IconTextField PhoneTextFlied;
    private javax.swing.JComboBox<String> StatusCombobox;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JComboBox<String> UserRoleCombobox;
    private com.CustomComponent.IconTextField UsernameTextFlied;
    private com.CustomizeUIComponent.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
