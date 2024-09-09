/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;



import com.EventInterface.EventActionCertificate;
import java.time.LocalDate;
import java.util.Date;

public class ModelCertificate {

    private int certificateID;
    private String studentID;
    private String certificateName;
    private Date issueDate;
    private Date expiryDate;
    private float grade;

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public ModelCertificate(int certificateID, String studentID, String certificateName,
            Date issueDate, Date expiryDate, float grade) {
        this.certificateID = certificateID;
        this.studentID = studentID;
        this.certificateName = certificateName;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.grade = grade;
    }

    public Object[] toRowTable(EventActionCertificate event) {
        return new Object[]{ studentID, certificateName, issueDate, expiryDate, grade, new ModelActionCertificate(this, event) };
    }
}
