package com.Dao;

import com.model.ModelCertificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CertificateDao {

    private static final String INSERT_CERTIFICATE_SQL = "INSERT INTO CertificateManagement (StudentID, CertificateName, IssueDate, ExpiryDate, Grade) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_CERTIFICATE_SQL = "DELETE FROM CertificateManagement WHERE CertificateID=?";
    private static final String SELECT_ALL_CERTIFICATES_SQL = "SELECT * FROM CertificateManagement";
    private static final String UPDATE_CERTIFICATE_SQL = "UPDATE CertificateManagement SET StudentID=?, CertificateName=?, IssueDate=?, ExpiryDate=?, Grade=? WHERE CertificateID=?";

    public void addCertificate(String studentID, String certificateName, String issueDate, String expiryDate, float grade) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CERTIFICATE_SQL)) {
            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, certificateName);
            preparedStatement.setString(3, issueDate);
            preparedStatement.setString(4, expiryDate);
            preparedStatement.setFloat(5, grade);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCertificate(int certificateID) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CERTIFICATE_SQL)) {
            preparedStatement.setInt(1, certificateID);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCertificate(int certificateID, String studentID, String certificateName, String issueDate, String expiryDate, float grade) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CERTIFICATE_SQL)) {
            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, certificateName);
            preparedStatement.setString(3, issueDate);
            preparedStatement.setString(4, expiryDate);
            preparedStatement.setFloat(5, grade);
            preparedStatement.setInt(6, certificateID);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelCertificate> getAllCertificates() {
        List<ModelCertificate> certificates = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CERTIFICATES_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ModelCertificate certificate = new ModelCertificate(
                        resultSet.getInt("CertificateID"),
                        resultSet.getString("StudentID"),
                        resultSet.getString("CertificateName"),
                       resultSet.getDate("IssueDate"),
                        resultSet.getDate("ExpiryDate"),
                        resultSet.getFloat("Grade")
                );
                certificates.add(certificate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificates;
    }

    public List<ModelCertificate> getCertificatesByStudentID(String studentID) {
        List<ModelCertificate> certificates = getAllCertificates();
         List<ModelCertificate> studentcerCertificates = certificates.stream()
                .filter(certificate -> certificate.getStudentID().equals(studentID))
                .collect(Collectors.toList()); 
        if( studentcerCertificates == null)
        {
               return  new ArrayList<>(); 
        }
        return  studentcerCertificates ; 
     
    }
}
