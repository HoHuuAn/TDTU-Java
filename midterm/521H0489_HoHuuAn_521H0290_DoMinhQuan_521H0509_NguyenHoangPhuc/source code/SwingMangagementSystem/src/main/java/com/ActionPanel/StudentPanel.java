/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ActionPanel;

import com.Dao.StudentDao;
import com.EventInterface.EventActionStudent;
import com.JdialogAction.InputDialogStudent;
import com.JdialogAction.StudentDetail;
import com.model.ModelStudent;
import com.model.ModelUser;
import com.model.StudentComparator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class StudentPanel extends javax.swing.JPanel {
    private final StudentDao studentDao;
    private ModelUser loginUser ; 
    private String searchText  ;  
    /**
     * Creates new form StudentPanel
     */
    public StudentPanel(ModelUser loginUser ) {
        studentDao = new StudentDao();
        this.loginUser = loginUser;
      
        initComponents();
         
        initTableData();
         if(loginUser.getUserRole() == 1)
         {   
             table1.setTableVisible(false);
             ActionLabel.setVisible(false);
             UserAddingButton.setVisible(false);
             EXPORTSTUDENT.setVisible(false);
             IMPORTSTUDENT.setVisible(false);
         }
            
    }
     private boolean containsSearchText(ModelStudent student) {
        // Check if any property of the student contains the search text
        String lowerSearchText = searchText.toLowerCase();

        return student.getID().toLowerCase().contains(lowerSearchText) ||
                student.getName().toLowerCase().contains(lowerSearchText) ||
                String.valueOf(student.getBeginningYear()).contains(lowerSearchText) ||
                String.valueOf(student.getEndYear()).contains(lowerSearchText) ||
                student.getMajor().toLowerCase().contains(lowerSearchText) ||
                student.getEducationQuality().toLowerCase().contains(lowerSearchText) ||
                student.getPhone().contains(lowerSearchText);
    }
    // each combox action need to include the get the text then set the search text 
    // when the key is press on the custom search bar the search text will auto matically activate 
    // when it hit the enter or search button then the text in side the custom text field will be empty 
    public List<ModelStudent> searchString()
    {
        if (searchText == null || searchText.isEmpty()) {
            return studentDao.getAllStudents();
        }

        List<ModelStudent> searchList = new ArrayList<ModelStudent>();

        for (ModelStudent student : studentDao.getAllStudents()) {
            if (containsSearchText(student)) {
                searchList.add(student);
            }
        }

        return searchList;
    }
   

    private void initTableData() {
        EventActionStudent eventAction = new EventActionStudent() {
            @Override
            public void delete(ModelStudent student) {
                 if(table1.isEditing())
        {   
            table1.getCellEditor().stopCellEditing();
        }
       
     
        studentDao.deleteStudent(student.getID());
                Reload();
            }

            @Override
            public void update(ModelStudent student) {
                 if(table1.isEditing())
        {
            table1.getCellEditor().stopCellEditing();
        }
             InputDialogStudent inputDialog = new InputDialogStudent((Frame) SwingUtilities.getWindowAncestor(table1), true,student);

            inputDialog.setVisible(true);
                Reload();
            }

            @Override
            public void view(ModelStudent student) {
                if(table1.isEditing())
        {
            table1.getCellEditor().stopCellEditing();
        }
                StudentDetail inputDialog = new StudentDetail((Frame) SwingUtilities.getWindowAncestor(table1), true,student,loginUser);

            inputDialog.setVisible(true);
                Reload();
            }
        };
     

    String selectedMajor = MAJORCOMBOBOX.getSelectedItem().toString();
    String selectedQuality = QUALITYCOMBOBOX.getSelectedItem().toString();
    String selectedSortingCriteria = STUDENTSORTCOMBOBOX.getSelectedItem().toString();
    Comparator<ModelStudent> comparator = new StudentComparator(selectedSortingCriteria);

    // Clear the existing rows in the table
    int CountStudent =0 ; 
    List<ModelStudent> students =  searchString();
    students.sort(comparator);
    // Loop through students and filter based on the selected values
    for (ModelStudent student : students) {
        // Convert major and quality to lowercase for case-insensitive comparison
        String studentMajor = student.getMajor().toLowerCase();
        String studentQuality = student.getEducationQuality().toLowerCase();

        // Check if the student matches the selected values
        if (("ALL".equalsIgnoreCase(selectedMajor) || selectedMajor.equalsIgnoreCase(studentMajor)) &&
            ("All".equalsIgnoreCase(selectedQuality) || selectedQuality.equalsIgnoreCase(studentQuality))) {
     
            table1.addRow(student.toRowTable(eventAction));
            CountStudent++ ; 
        }
    }
        jLabel4.setText("Student Number : "+CountStudent);
    }
      
     private void Reload() {
        table1.ClearTable();
        initTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
//
//    private void initComponents() {
//
//        jButton1 = new javax.swing.JButton();
//        jPanel1 = new javax.swing.JPanel();
//        jPanel3 = new javax.swing.JPanel();
//        MAJORCOMBOBOX = new javax.swing.JComboBox<>();
//        QUALITYCOMBOBOX = new javax.swing.JComboBox<>();
//        jPanel6 = new javax.swing.JPanel();
//        STUDENTSORTCOMBOBOX = new javax.swing.JComboBox<>();
//        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
//        customTextField1 = new com.CustomComponent.CustomTextField();
//        jPanel2 = new javax.swing.JPanel();
//        jPanel4 = new javax.swing.JPanel();
//        lightBule2 = new PaintComponent.LightBule();
//        jLabel1 = new javax.swing.JLabel();
//        jLabel4 = new javax.swing.JLabel();
//        blueGradianPain1 = new PaintComponent.BlueGradianPain();
//        ActionLabel = new javax.swing.JLabel();
//        UserAddingButton = new javax.swing.JButton();
//        EXPORTSTUDENT = new javax.swing.JToggleButton();
//        IMPORTSTUDENT = new javax.swing.JToggleButton();
//        jPanel5 = new javax.swing.JPanel();
//        jScrollPane2 = new javax.swing.JScrollPane();
//        table1 = new com.SwingTable.Table();
//
//        jButton1.setText("jButton1");
//
//        setPreferredSize(new java.awt.Dimension(1058, 741));
//        setLayout(new java.awt.BorderLayout());
//
//        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
//        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));
//
//        MAJORCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL","FOREIGN LANGUAGE", "INDUSTRIAL DESIGN", "ACCOUNTING", "SOCIAL SCIENCES", "ELECTRICAL ENGINEERING", "INFORMATION TECHNOLOGY", "AEROSPACE ENGINEERING", "BUSINESS ADMINISTRATION", "CIVIL ENGINEERING", "ENVIRONMENTAL HEALTH", "LIFE SCIENCES", "FINANCE BANKING", "MECHANICAL ENGINEERING", "SOCIAL WORK", "LAW", "DATA SCIENCE" }));
//        MAJORCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                MAJORCOMBOBOXActionPerformed(evt);
//            }
//        });
//        jPanel3.add(MAJORCOMBOBOX);
//
//        QUALITYCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "REGULAR QUALITY", "JOINT PROGRAM", "HIGH QUALITY" }));
////        QUALITYCOMBOBOX.setPreferredSize(new java.awt.Dimension(72, 50));
//        QUALITYCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                QUALITYCOMBOBOXActionPerformed(evt);
//            }
//        });
//        jPanel3.add(QUALITYCOMBOBOX);
//
//        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
//        jPanel6.setPreferredSize(new java.awt.Dimension(148, 54));
//        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));
//
//        STUDENTSORTCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "START YEAR", "END YEAR", "STUDENT ID" }));
//        STUDENTSORTCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                STUDENTSORTCOMBOBOXActionPerformed(evt);
//            }
//        });
//        jPanel6.add(STUDENTSORTCOMBOBOX);
//
//        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
//        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
//        jLabel2.setText("Sort Student : ");
//
//        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
//        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
//        jLabel3.setText("Find Student : ");
//
//        customTextField1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                customTextField1ActionPerformed(evt);
//            }
//        });
//        customTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyPressed(java.awt.event.KeyEvent evt) {
//                customTextField1KeyPressed(evt);
//            }
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                customTextField1KeyTyped(evt);
//            }
//        });
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                .addGap(42, 42, 42)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(customTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jLabel3))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
//                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jLabel2)
//                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
//                .addGap(56, 56, 56))
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(19, 19, 19)
//                .addComponent(customTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel3)
//                    .addComponent(jLabel2))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
//                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
//        );
//
//        add(jPanel1, java.awt.BorderLayout.PAGE_START);
//
//        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));
//
//        lightBule2.setPreferredSize(new java.awt.Dimension(330, 280));
//
//        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(153, 255, 255));
//        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel1.setText("Student Count :");
//
//        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        jLabel4.setForeground(new java.awt.Color(153, 255, 255));
//        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        jLabel4.setText("Student Number : 0");
//
//        javax.swing.GroupLayout lightBule2Layout = new javax.swing.GroupLayout(lightBule2);
//        lightBule2.setLayout(lightBule2Layout);
//        lightBule2Layout.setHorizontalGroup(
//            lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(lightBule2Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel1)
//                    .addComponent(jLabel4))
//                .addContainerGap(103, Short.MAX_VALUE))
//        );
//        lightBule2Layout.setVerticalGroup(
//            lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(lightBule2Layout.createSequentialGroup()
//                .addGap(29, 29, 29)
//                .addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jLabel4)
//                .addContainerGap(189, Short.MAX_VALUE))
//        );
//
//        jPanel4.add(lightBule2);
//
//        blueGradianPain1.setPreferredSize(new java.awt.Dimension(330, 280));
//
//        ActionLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        ActionLabel.setForeground(new java.awt.Color(153, 255, 255));
//        ActionLabel.setText("Student Action :");
//
//        UserAddingButton.setBackground(new java.awt.Color(0, 153, 153));
//        UserAddingButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        UserAddingButton.setForeground(new java.awt.Color(0, 102, 102));
//        UserAddingButton.setText("Add Student");
//        UserAddingButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                UserAddingButtonActionPerformed(evt);
//            }
//        });
//
//        EXPORTSTUDENT.setBackground(new java.awt.Color(0, 153, 153));
//        EXPORTSTUDENT.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        EXPORTSTUDENT.setForeground(new java.awt.Color(0, 102, 102));
//        EXPORTSTUDENT.setText("EXPORT STUDENT");
//        EXPORTSTUDENT.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                EXPORTSTUDENTActionPerformed(evt);
//            }
//        });
//
//        IMPORTSTUDENT.setBackground(new java.awt.Color(0, 153, 153));
//        IMPORTSTUDENT.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
//        IMPORTSTUDENT.setForeground(new java.awt.Color(0, 102, 102));
//        IMPORTSTUDENT.setText("IMPORT STUDENT");
//        IMPORTSTUDENT.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                IMPORTSTUDENTActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout blueGradianPain1Layout = new javax.swing.GroupLayout(blueGradianPain1);
//        blueGradianPain1.setLayout(blueGradianPain1Layout);
//        blueGradianPain1Layout.setHorizontalGroup(
//            blueGradianPain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(blueGradianPain1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(blueGradianPain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(ActionLabel)
//                    .addComponent(UserAddingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(EXPORTSTUDENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(IMPORTSTUDENT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap(76, Short.MAX_VALUE))
//        );
//        blueGradianPain1Layout.setVerticalGroup(
//            blueGradianPain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(blueGradianPain1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(ActionLabel)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(UserAddingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(EXPORTSTUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(IMPORTSTUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(72, Short.MAX_VALUE))
//        );
//
//        jPanel4.add(blueGradianPain1);
//
//        jPanel5.setLayout(new java.awt.BorderLayout());
//
//        table1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//
//            },
//            new String [] {
//                "ID", "NAME", "START YEAR", "END YEAR", "MAJOR", "EQ", "PHONE", "ACTION"
//            }
//        ));
//        jScrollPane2.setViewportView(table1);
//
//        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);
//
//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel2Layout.createSequentialGroup()
//                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap())
//        );
//        jPanel2Layout.setVerticalGroup(
//            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel2Layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
//                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(30, 30, 30))
//                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
//        );
//
//        add(jPanel2, java.awt.BorderLayout.CENTER);
//    }// </editor-fold>//GEN-END:initComponents



    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        MAJORCOMBOBOX = new javax.swing.JComboBox<>();
        QUALITYCOMBOBOX = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        STUDENTSORTCOMBOBOX = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customTextField1 = new com.CustomComponent.CustomTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lightBule2 = new PaintComponent.LightBule();
        jLabel4 = new javax.swing.JLabel();
        ActionLabel = new javax.swing.JLabel();
        UserAddingButton = new javax.swing.JButton();
        EXPORTSTUDENT = new javax.swing.JToggleButton();
        IMPORTSTUDENT = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.SwingTable.Table();

        jButton1.setText("jButton1");

        setPreferredSize(new java.awt.Dimension(1058, 741));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.X_AXIS));

        MAJORCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "FOREIGN LANGUAGE", "INDUSTRIAL DESIGN", "ACCOUNTING", "SOCIAL SCIENCES", "ELECTRICAL ENGINEERING", "INFORMATION TECHNOLOGY", "AEROSPACE ENGINEERING", "BUSINESS ADMINISTRATION", "CIVIL ENGINEERING", "ENVIRONMENTAL HEALTH", "LIFE SCIENCES", "FINANCE BANKING", "MECHANICAL ENGINEERING", "SOCIAL WORK", "LAW", "DATA SCIENCE" }));
        MAJORCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAJORCOMBOBOXActionPerformed(evt);
            }
        });
        jPanel3.add(MAJORCOMBOBOX);

        QUALITYCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "REGULAR QUALITY", "JOINT PROGRAM", "HIGH QUALITY" }));
        QUALITYCOMBOBOX.setName(""); // NOI18N
        QUALITYCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QUALITYCOMBOBOXActionPerformed(evt);
            }
        });
        jPanel3.add(QUALITYCOMBOBOX);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(148, 54));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.X_AXIS));

        STUDENTSORTCOMBOBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "START YEAR", "END YEAR", "STUDENT ID" }));
        STUDENTSORTCOMBOBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STUDENTSORTCOMBOBOXActionPerformed(evt);
            }
        });
        jPanel6.add(STUDENTSORTCOMBOBOX);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("Sort Student : ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
        jLabel3.setText("Find Student : ");

        customTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customTextField1ActionPerformed(evt);
            }
        });
        customTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(customTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(customTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        lightBule2.setPreferredSize(new java.awt.Dimension(330, 250));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Student Number : 0");

        ActionLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ActionLabel.setText("Student Action :");

        UserAddingButton.setBackground(new java.awt.Color(0, 153, 153));
        UserAddingButton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        UserAddingButton.setText("Add Student");
        UserAddingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserAddingButtonActionPerformed(evt);
            }
        });

        EXPORTSTUDENT.setBackground(new java.awt.Color(0, 153, 153));
        EXPORTSTUDENT.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        EXPORTSTUDENT.setText("EXPORT STUDENT");
        EXPORTSTUDENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXPORTSTUDENTActionPerformed(evt);
            }
        });

        IMPORTSTUDENT.setBackground(new java.awt.Color(0, 153, 153));
        IMPORTSTUDENT.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        IMPORTSTUDENT.setText("IMPORT STUDENT");
        IMPORTSTUDENT.setPreferredSize(new java.awt.Dimension(248, 35));
        IMPORTSTUDENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPORTSTUDENTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lightBule2Layout = new javax.swing.GroupLayout(lightBule2);
        lightBule2.setLayout(lightBule2Layout);
        lightBule2Layout.setHorizontalGroup(
                lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lightBule2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ActionLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(103, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lightBule2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IMPORTSTUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EXPORTSTUDENT)
                                        .addComponent(UserAddingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
        );
        lightBule2Layout.setVerticalGroup(
                lightBule2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lightBule2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ActionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UserAddingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EXPORTSTUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(IMPORTSTUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.add(lightBule2, new java.awt.GridBagConstraints());

        jPanel5.setLayout(new java.awt.BorderLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "NAME", "START YEAR", "END YEAR", "MAJOR", "EQ", "PHONE", "ACTION"
                }
        ));
        jScrollPane2.setViewportView(table1);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>

    private void customTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextField1KeyPressed
    
        
    }//GEN-LAST:event_customTextField1KeyPressed
    
    private void MAJORCOMBOBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAJORCOMBOBOXActionPerformed
    Reload() ;
// TODO add your handling code here:
    }//GEN-LAST:event_MAJORCOMBOBOXActionPerformed

    private void UserAddingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserAddingButtonActionPerformed
        if(table1.isEditing())
        {
            table1.getCellEditor().stopCellEditing();
        }
        InputDialogStudent inputDialog = new InputDialogStudent((Frame) SwingUtilities.getWindowAncestor(table1), true);

        inputDialog.setVisible(true);

        Reload();
        // Create a new JDialog
    }//GEN-LAST:event_UserAddingButtonActionPerformed

    private void QUALITYCOMBOBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QUALITYCOMBOBOXActionPerformed
    Reload() ;

    }//GEN-LAST:event_QUALITYCOMBOBOXActionPerformed

    private void STUDENTSORTCOMBOBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENTSORTCOMBOBOXActionPerformed
         Reload() ; 
    }//GEN-LAST:event_STUDENTSORTCOMBOBOXActionPerformed
    
    
    
    private void customTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customTextField1ActionPerformed
        String text = customTextField1.getText() ; 
      
        this.searchText =  text ; 
        customTextField1.setText("");
        Reload();
    }//GEN-LAST:event_customTextField1ActionPerformed

    private void customTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customTextField1KeyTyped
      char typedChar = evt.getKeyChar();

    if (typedChar == KeyEvent.VK_BACK_SPACE) {
        // Handle backspace separately
        handleBackspace();
    } else if (typedChar != KeyEvent.VK_ENTER) {
        // Handle other characters
        handleOtherCharacters(typedChar);
    }
    
    }//GEN-LAST:event_customTextField1KeyTyped

    private void EXPORTSTUDENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXPORTSTUDENTActionPerformed

        List<ModelStudent> studentList =  studentDao.getAllStudents();




        // Choose Location For Saving Excel File
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Authentic\\Desktop");
        // Change Dialog Box Title
        excelFileChooser.setDialogTitle("Save As");
        // Only filter files with these extensions "xls", "xlsx", "xlsm"
        FileNameExtensionFilter excelf = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV FILES", "csv");
        excelFileChooser.setFileFilter(excelf);
        excelFileChooser.setFileFilter(csvFilter);

        int excelChooser = excelFileChooser.showSaveDialog(null);

        // Check if save button is clicked
        if (excelChooser == JFileChooser.APPROVE_OPTION) {


            // Show export options dialog
//        Object[] options = {"Export to Excel", "Export to CSV"};
//        int exportChoice = JOptionPane.showOptionDialog(null, "Choose export format:", "Export Options",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            FileNameExtensionFilter selectedFilter = (FileNameExtensionFilter) excelFileChooser.getFileFilter();
            // Process user's export choice
            if (selectedFilter.equals(excelf)) {
                exportToExcelStudent(studentList, excelFileChooser);
            } else{
                exportToCSVStudent(studentList, excelFileChooser);
            }

        }
    }//GEN-LAST:event_EXPORTSTUDENTActionPerformed
    private void exportToExcelStudent(List<ModelStudent> studentList, JFileChooser excelFileChooser) {
        XSSFWorkbook excelJTableExporter = null;
        BufferedOutputStream excelBOU = null;
        FileOutputStream excelFOU = null;
        excelJTableExporter = new XSSFWorkbook();
        try {

            // Import excel poi libraries to netbeans

            XSSFSheet excelSheet = excelJTableExporter.createSheet("Student Data");

            // Create header row
            XSSFRow headerRow = excelSheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("NAME");
            headerRow.createCell(2).setCellValue("BEGINNING YEAR");
            headerRow.createCell(3).setCellValue("END YEAR");
            headerRow.createCell(4).setCellValue("MAJOR");
            headerRow.createCell(5).setCellValue("EDUCATION QUALITY");
            headerRow.createCell(6).setCellValue("PHONE");

            // Populate data rows
            for (int i = 0; i < studentList.size(); i++) {
                ModelStudent student = studentList.get(i);
                XSSFRow dataRow = excelSheet.createRow(i + 1);

                dataRow.createCell(0).setCellValue(student.getID());
                dataRow.createCell(1).setCellValue(student.getName());
                dataRow.createCell(2).setCellValue(student.getBeginningYear());
                dataRow.createCell(3).setCellValue(student.getEndYear());
                dataRow.createCell(4).setCellValue(student.getMajor());
                dataRow.createCell(5).setCellValue(student.getEducationQuality());
                dataRow.createCell(6).setCellValue(student.getPhone());
            }

            // Append xlsx file extensions to selected files. To create unique file names
            excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
            excelBOU = new BufferedOutputStream(excelFOU);
            excelJTableExporter.write(excelBOU);
            JOptionPane.showMessageDialog(null, "Exported Successfully !!!........");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (excelBOU != null) {
                    excelBOU.close();
                }
                if (excelFOU != null) {
                    excelFOU.close();
                }
                if (excelJTableExporter != null) {
                    excelJTableExporter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void exportToCSVStudent(List<ModelStudent> studentList, JFileChooser excelFileChooser) {
        // Create CSV file
        try (FileWriter csvWriter = new FileWriter(excelFileChooser.getSelectedFile() + ".csv")) {
            // Write CSV header
            csvWriter.append("ID,NAME,BEGINNING YEAR,END YEAR,MAJOR,EDUCATION QUALITY,PHONE");
            csvWriter.append("\n");

            // Write CSV data
            for (ModelStudent student : studentList) {
                csvWriter.append(String.join(",",
                        String.valueOf(student.getID()),
                        student.getName(),
                        String.valueOf(student.getBeginningYear()),
                        String.valueOf(student.getEndYear()),
                        student.getMajor(),
                        student.getEducationQuality(),
                        student.getPhone()));
                csvWriter.append("\n");
            }

            JOptionPane.showMessageDialog(null, "Exported to CSV Successfully !!!........");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void IMPORTSTUDENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPORTSTUDENTActionPerformed

        File excelFile;

        String defaultCurrentDirectoryPath = "C:\\Users\\Authentic\\Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV FILES", "csv");
        excelFileChooser.setFileFilter(fnef);
        excelFileChooser.setFileFilter(csvFilter);

        int excelChooser = excelFileChooser.showOpenDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            File selectedFile = excelFileChooser.getSelectedFile();
            FileNameExtensionFilter selectedFilter = (FileNameExtensionFilter) excelFileChooser.getFileFilter();

            if (selectedFilter.equals(fnef)) {
                // User selected the EXCEL FILES filter, import from Excel
                importStudentsFromExcel(selectedFile);
            } else if (selectedFilter.equals(csvFilter)) {
                importStudentsFromCSV(selectedFile);
                // User selected the CSV FILES filter, export to CSV

            }}
    }//GEN-LAST:event_IMPORTSTUDENTActionPerformed


    public void importStudentsFromCSV(File csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (headers == null) {
                    // First line is the header
                    headers = values;
                    continue;
                }

                // Find the index of each column based on the header

                int nameIndex = findIndex(headers, "NAME");
                int beginningYearIndex = findIndex(headers, "BEGINNING YEAR");
                int endYearIndex = findIndex(headers, "END YEAR");
                int majorIndex = findIndex(headers, "MAJOR");
                int educationQualityIndex = findIndex(headers, "EDUCATION QUALITY");
                int phoneIndex = findIndex(headers, "PHONE");

                // Use the found indices to get the values

                String name = values[nameIndex].trim();
                int beginningYear = Integer.parseInt(values[beginningYearIndex]);
                int endYear = Integer.parseInt(values[endYearIndex]);
                String major = values[majorIndex].trim();
                String educationQuality = values[educationQualityIndex].trim();
                String phone = values[phoneIndex].trim();

                // Assuming you have a method in studentDao to add a student
                studentDao.addStudent(name, beginningYear, endYear, major, educationQuality, phone);
            }

            JOptionPane.showMessageDialog(null, "Import from CSV Successfully !!!........");
            Reload();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error importing from CSV: " + e.getMessage());
        }
    }

    // Helper method to find the index of a column in the header
    private int findIndex(String[] headers, String columnName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        return -1; // Not found
    }

    public void importStudentsFromExcel(File excelFile) {
        int nameIndex = -1;
        int startYearIndex = -1;
        int endYearIndex = -1;
        int majorIndex = -1;
        int eqIndex = -1;
        int phoneIndex = -1;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;

        try {
            excelFIS = new FileInputStream(excelFile);
            excelBIS = new BufferedInputStream(excelFIS);
            excelImportToJTable = new XSSFWorkbook(excelBIS);
            XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

            XSSFRow excelRow = excelSheet.getRow(0);
            if (excelRow != null) {
                for (int cell = 0; cell < excelRow.getLastCellNum(); cell++) {
                    XSSFCell currentCell = excelRow.getCell(cell);

                    // Check if the cell is not null before getting its value
                    if (currentCell != null) {
                        String cellValue = currentCell.toString();
                        switch (cellValue.toUpperCase()) {
                            case "NAME":
                                nameIndex = cell;

                                break;
                            case "BEGINNING YEAR":
                                startYearIndex = cell;

                                break;
                            case "END YEAR":
                                endYearIndex = cell;

                                break;
                            case "MAJOR":
                                majorIndex = cell;
                                break;
                            case "EDUCATION QUALITY":
                                eqIndex = cell;
                                break;
                            case "PHONE":
                                phoneIndex = cell;

                                break;
                            // Add more cases as needed for additional columns
                        }
                    }
                }
            }

            for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                excelRow = excelSheet.getRow(row);

                XSSFCell excelName = excelRow.getCell(nameIndex);
                String name = excelName.getStringCellValue().trim();

                XSSFCell excelMajor = excelRow.getCell(majorIndex);
                String major = excelMajor.getStringCellValue().trim();

                XSSFCell excelEQ = excelRow.getCell(eqIndex);
                String eq = excelEQ.getStringCellValue().trim();

                int startYear = 0;
                int endYear = 0;
                String phone = "";
//                System.out.println(eq) ;
//                System.out.println(major) ;

                XSSFCell startYearCell = excelRow.getCell(startYearIndex);
                if (startYearCell != null) {
                    if (startYearCell.getCellType() == CellType.STRING) {
                        startYear = Integer.parseInt(startYearCell.getStringCellValue().trim());
                    } else {
                        startYear = (int) startYearCell.getNumericCellValue();
                    }
                }

                XSSFCell endYearCell = excelRow.getCell(endYearIndex);
                if (endYearCell != null) {
                    if (endYearCell.getCellType() == CellType.STRING) {
                        endYear = Integer.parseInt(endYearCell.getStringCellValue().trim());
                    } else {
                        endYear = (int) endYearCell.getNumericCellValue();
                    }
                }

                XSSFCell excelPhone = excelRow.getCell(phoneIndex);
                if (excelPhone != null) {
                    if (excelPhone.getCellType() == CellType.STRING) {
                        phone = excelPhone.getStringCellValue().trim();
                    } else {
                        double numericValue = excelPhone.getNumericCellValue();
                        phone = String.valueOf((int) numericValue);
                    }
                }


                studentDao.addStudent(name, startYear, endYear, major, eq, phone);
            }

            JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException.getMessage());
        } finally {
            try {
                if (excelFIS != null) {
                    excelFIS.close();
                }
                if (excelBIS != null) {
                    excelBIS.close();
                }
                if (excelImportToJTable != null) {
                    excelImportToJTable.close();
                }
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            }
            Reload();
        }
    }





private void handleBackspace() {
    String text = customTextField1.getText();
    if (!text.isEmpty()) {
        text = text.substring(0, text.length() - 1);
        this.searchText = text;
       
        Reload();
    }
}

private void handleOtherCharacters(char typedChar) {
    String text = customTextField1.getText() + typedChar;
    this.searchText = text;
    Reload();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActionLabel;
    private javax.swing.JToggleButton EXPORTSTUDENT;
    private javax.swing.JToggleButton IMPORTSTUDENT;
    private javax.swing.JComboBox<String> MAJORCOMBOBOX;
    private javax.swing.JComboBox<String> QUALITYCOMBOBOX;
    private javax.swing.JComboBox<String> STUDENTSORTCOMBOBOX;
    private javax.swing.JButton UserAddingButton;
    private PaintComponent.BlueGradianPain blueGradianPain1;
    private com.CustomComponent.CustomTextField customTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private PaintComponent.LightBule lightBule2;
    private com.SwingTable.Table table1;
    // End of variables declaration//GEN-END:variables

    
}
