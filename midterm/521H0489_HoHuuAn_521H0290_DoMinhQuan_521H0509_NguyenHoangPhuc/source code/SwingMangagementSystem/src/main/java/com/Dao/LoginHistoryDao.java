package com.Dao;

import com.model.ModelLoginHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginHistoryDao {

    private static final String INSERT_LOGIN_HISTORY_SQL = "INSERT INTO LoginHistory (UserID, TimeLogin) VALUES (?, ?)";
    private static final String SELECT_LOGIN_HISTORY_SQL = "SELECT * FROM LoginHistory WHERE UserID=?";
    private static final String SELECT_ALL_LOGIN_HISTORY_SQL = "SELECT * FROM LoginHistory";
    private static final String DELETE_LOGIN_HISTORY_SQL = "DELETE FROM LoginHistory WHERE LoginHistoryID=?";

    public void addLoginHistory(int userID, java.sql.Timestamp timeLogin) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOGIN_HISTORY_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setTimestamp(2, timeLogin);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelLoginHistory> getLoginHistoryByUserID(int userID) {
        List<ModelLoginHistory> loginHistoryList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_HISTORY_SQL)) {
            preparedStatement.setInt(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ModelLoginHistory loginHistory = new ModelLoginHistory();
                    loginHistory.setLoginHistoryID(resultSet.getInt("LoginHistoryID"));
                    loginHistory.setUserID(resultSet.getInt("UserID"));
                    loginHistory.setTimeLogin(resultSet.getTimestamp("TimeLogin"));
                    loginHistoryList.add(loginHistory);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginHistoryList;
    }

    public List<ModelLoginHistory> getAllLoginHistory() {
        List<ModelLoginHistory> loginHistoryList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOGIN_HISTORY_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ModelLoginHistory loginHistory = new ModelLoginHistory();
                loginHistory.setLoginHistoryID(resultSet.getInt("LoginHistoryID"));
                loginHistory.setUserID(resultSet.getInt("UserID"));
                loginHistory.setTimeLogin(resultSet.getTimestamp("TimeLogin"));
                loginHistoryList.add(loginHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginHistoryList;
    }

    public void deleteLoginHistory(int loginHistoryID) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOGIN_HISTORY_SQL)) {
            preparedStatement.setInt(1, loginHistoryID);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
