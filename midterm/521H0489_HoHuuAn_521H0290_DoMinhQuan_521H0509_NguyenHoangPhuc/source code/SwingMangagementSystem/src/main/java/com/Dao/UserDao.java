// UserDao.java
package com.Dao;


import com.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.stream.Collectors;
public class UserDao {
    
//    private static final String INSERT_USER_SQL = "INSERT INTO UserManagement (UserName, Password, ProfilePicture, Age, PhoneNumber, Status, UserRole) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_USER_SQL = "DELETE FROM UserManagement WHERE UserID=?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM UserManagement";
    private static final String UPDATE_USER_SQL = "UPDATE UserManagement SET UserName=?, Password=?, ProfilePicture=?, Age=?, PhoneNumber=?, Status=?, UserRole=? WHERE UserID=?";

    private static final String AUTHENTICATE_USER_SQL = "SELECT * FROM UserManagement WHERE UserName = ? AND Password = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO UserManagement (UserName, Password, ProfilePicture, Age, PhoneNumber, Status, UserRole) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public void addUser(String userName, String password, String profilePicture, int age, String phoneNumber, int status, int userRole) {
    try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, profilePicture);
        preparedStatement.setInt(4, age);
        preparedStatement.setString(5, phoneNumber);
        preparedStatement.setInt(6, status);
        preparedStatement.setInt(7, userRole);
        preparedStatement.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void deleteUser(int userId) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, userId);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(int userId, String userName, String password, String profilePicture, int age, String phoneNumber, int status, int userRole) {
    try (Connection connection = ConnectionFactory.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, profilePicture);
        preparedStatement.setInt(4, age);
        preparedStatement.setString(5, phoneNumber);
        preparedStatement.setInt(6, status);
        preparedStatement.setInt(7, userRole);
        preparedStatement.setInt(8, userId);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {

        } else {

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
 public List<ModelUser> getAllUsers() {
    List<ModelUser> users = new ArrayList<>();
    try (Connection connection = ConnectionFactory.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            ModelUser user = new ModelUser(
                    resultSet.getInt("UserID"),
                    resultSet.getString("UserName"),
                    resultSet.getString("Password"),
                    resultSet.getString("ProfilePicture"),
                    resultSet.getInt("Age"),
                    resultSet.getString("PhoneNumber"),
                    resultSet.getInt("Status"),
                    resultSet.getInt("UserRole"));
 

            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}
 
 public List<ModelUser> getAllEmployeeAndManager() {
        List<ModelUser> users = this.getAllUsers();

        // Sort the list based on UserRole
       List<ModelUser> filteredUsers = users.stream()
                .filter(user -> user.getUserRole() != 2)
                .collect(Collectors.toList());

        return filteredUsers;
    }
 
  public ModelUser authenticate(String username, String password) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(AUTHENTICATE_USER_SQL);
        ) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if the result set has any rows
                if (resultSet.next()) {
                    // Create a ModelUser object with the data from the result set
                    return new ModelUser(
                            resultSet.getInt("UserID"),
                            resultSet.getString("UserName"),
                            resultSet.getString("Password"),
                            resultSet.getString("ProfilePicture"),
                            resultSet.getInt("Age"),
                            resultSet.getString("PhoneNumber"),
                            resultSet.getInt("Status"),
                            resultSet.getInt("UserRole")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if authentication fails
    }
}
