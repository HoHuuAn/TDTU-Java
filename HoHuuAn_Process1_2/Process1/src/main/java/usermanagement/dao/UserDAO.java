package usermanagement.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usermanagement.db.DBConnect;
import usermanagement.model.User;

public class UserDAO {
    private Connection conn;
    private int noOfRecords;
    Statement stmt;
    public int getNoOfRecords() { return noOfRecords; }
    public UserDAO()  {conn = DBConnect.getConn();}

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (id, name, email, phone, IsActive) VALUES  (?, ?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,phone,IsActive from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, phone = ?, IsActive = ? where id = ?;";
    private static final String SELECT_ID_USERS = "SELECT id FROM users;";
    public Integer insertUser(User user) throws SQLException {
         PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);
         preparedStatement.setString(1, user.getUserID());
         preparedStatement.setString(2, user.getEmail());
         preparedStatement.setString(3, user.getEmail());
         preparedStatement.setString(4, user.getMobilePhone());
         preparedStatement.setInt(5, user.getActive());

         return preparedStatement.executeUpdate();
    }

    public User selectUser(String id) {
        User user = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("name");
                String email = rs.getString("email");
                String mobilePhone = rs.getString("phone");
                int isActive = rs.getInt("IsActive");

                user = new User(id, userName, email, mobilePhone, isActive);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<String> selectAllId() {
        List<String> listID = new ArrayList<>();;
        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ID_USERS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                listID.add(id);
            }
            rs.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listID;
    }

    public List<User> selectAllUsers(int offset, int noOfRecords) {
        List<User> list = new ArrayList<>();

        String query = "select SQL_CALC_FOUND_ROWS * from users limit " + offset + ", " + noOfRecords;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String userID = rs.getString("id");
                String userName = rs.getString("name");
                String email = rs.getString("email");
                String mobilePhone = rs.getString("phone");
                int isActive = rs.getInt("IsActive");
                Date dateCreated = rs.getTimestamp("DateCreated");

                User user = new User(userID,userName,email,mobilePhone,isActive, dateCreated);
                list.add(user);
            }
            rs.close();
            rs = stmt.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next())
                this.noOfRecords = rs.getInt(1);

        } catch (SQLException e) {
            printSQLException(e);
        }
        finally
        {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean deleteUser(String id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USERS_SQL);
        preparedStatement.setString(1, id);
        rowDeleted = preparedStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getMobilePhone());
        preparedStatement.setInt(4, user.getActive());
        preparedStatement.setString(5, user.getUserID());

        return preparedStatement.executeUpdate() > 0;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}