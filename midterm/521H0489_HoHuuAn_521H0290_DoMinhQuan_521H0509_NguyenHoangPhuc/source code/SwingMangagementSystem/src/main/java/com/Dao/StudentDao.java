// StudentDao.java
package com.Dao;

import com.model.ModelStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentDao {

  private static final String INSERT_STUDENT_SQL = "INSERT INTO Student (ID, Name, BeginningYear, EndYear, Major, EducationQuality, Phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
private static final String DELETE_STUDENT_SQL = "DELETE FROM Student WHERE ID=?";
private static final String SELECT_ALL_STUDENTS_SQL = "SELECT * FROM Student";
private static final String UPDATE_STUDENT_SQL = "UPDATE Student SET Name=?, BeginningYear=?, EndYear=?, Major=?, EducationQuality=?, Phone=? WHERE ID=?";

    
    
    
    public static String generateCode(int enrollmentYear, String departmentCode, String qualityCode) {
        Map<String, String> switchedTrainingSystemCodes = new HashMap<>();
        switchedTrainingSystemCodes.put("REGULAR QUALITY", "0");
        switchedTrainingSystemCodes.put("JOINT PROGRAM", "F");
        switchedTrainingSystemCodes.put("HIGH QUALITY", "H");

        Map<String, String> switchedDepartmentCodes = new HashMap<>();
        switchedDepartmentCodes.put("FOREIGN LANGUAGE", "0");
        switchedDepartmentCodes.put("INDUSTRIAL DESIGN", "1");
        switchedDepartmentCodes.put("ACCOUNTING", "2");
        switchedDepartmentCodes.put("SOCIAL SCIENCES", "3");
        switchedDepartmentCodes.put("ELECTRICAL ENGINEERING", "4");
        switchedDepartmentCodes.put("INFORMATION TECHNOLOGY", "5");
        switchedDepartmentCodes.put("AEROSPACE ENGINEERING", "6");
        switchedDepartmentCodes.put("BUSINESS ADMINISTRATION", "7");
        switchedDepartmentCodes.put("CIVIL ENGINEERING", "8");
        switchedDepartmentCodes.put("ENVIRONMENTAL HEALTH", "9");
        switchedDepartmentCodes.put("LIFE SCIENCES", "A");
        switchedDepartmentCodes.put("FINANCE BANKING", "B");
        switchedDepartmentCodes.put("MECHANICAL ENGINEERING", "C");
        switchedDepartmentCodes.put("SOCIAL WORK", "D");
        switchedDepartmentCodes.put("LAW", "E");
        switchedDepartmentCodes.put("DATA SCIENCE", "H");
        // Extract the last two digits of the enrollment year
        int lastTwoDigitsOfYear = enrollmentYear % 100;

        // Ensure the last two digits are in the range 0-99
        lastTwoDigitsOfYear = Math.floorMod(lastTwoDigitsOfYear, 100);

        // Convert the last two digits to a string
        String yearCode = String.format("%02d", lastTwoDigitsOfYear);

        // Ensure the department code is uppercase
        departmentCode = switchedDepartmentCodes.get(departmentCode.toUpperCase()) ;

        // Ensure the quality code is uppercase
        qualityCode = switchedTrainingSystemCodes.get(qualityCode.toUpperCase());

        // Generate a random 4-digit number
        String randomNumbers = String.format("%04d", new Random().nextInt(10000));

        // Combine the components to form the final code
        return  departmentCode +yearCode  + qualityCode + randomNumbers;
    }
    
    
      public void addStudent(String name, int beginningYear, int endYear, String major, String educationQuality, String phone) {
        String generatedID = generateCode(beginningYear, major, educationQuality);

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, generatedID);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, beginningYear);
            preparedStatement.setInt(4, endYear);
            preparedStatement.setString(5, major);
            preparedStatement.setString(6, educationQuality);
            preparedStatement.setString(7, phone);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String ID) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setString(1, ID);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(String ID, String name, int beginningYear, int endYear, String major, String educationQuality, String phone) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, beginningYear);
            preparedStatement.setInt(3, endYear);
            preparedStatement.setString(4, major);
            preparedStatement.setString(5, educationQuality);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, ID);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelStudent> getAllStudents() {
    List<ModelStudent> students = new ArrayList<>();
    try (Connection connection = ConnectionFactory.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS_SQL);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            ModelStudent student = new ModelStudent(
                    resultSet.getString("ID"),
                    resultSet.getString("Name"),
                    resultSet.getInt("BeginningYear"),
                    resultSet.getInt("EndYear"),
                    resultSet.getString("Major"),
                    resultSet.getString("EducationQuality"),
                    resultSet.getString("Phone"));

            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return students;
}

    public List<ModelStudent> getAllMajorAndEducationQuality() {
        List<ModelStudent> students = this.getAllStudents();

        // Add your logic here to filter students based on specific conditions
        // For example, students with specific major and education quality
        List<ModelStudent> filteredStudents = students.stream()
                .filter(student -> /* add your condition here */ true)
                .collect(Collectors.toList());

        return filteredStudents;
    }
}
