package usermanagement.dao;

import usermanagement.db.DBConnect;
import usermanagement.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {

    Connection conn;
    private int noOfRecords;
    Statement stmt;
    public int getNoOfRecords() { return noOfRecords; }

    private static final String INSERT_MANAGERS_SQL = "INSERT INTO managers" + "  (id, fullName, email, password) VALUES  (?, ?, ?, ?);";
    private static final String SELECTID_MANAGERS_SQL = "SELECT id FROM managers;";
    private static final String DELETE_MANAGERS_SQL = "delete from managers where id = ?;";
    private static final String SELECT_MANAGERS_BY_ID = "select fullName,email,password from managers where id =?;";
    private static final String UPDATE_MANAGERS_SQL = "update managers set fullName = ?,email= ?, password = ? where id = ?;";
    private static final String SELECT_ALL_MANAGERS = "SELECT * FROM managers;";

    public ManagerDAO(){conn = DBConnect.getConn();}

    public boolean add(Manager manager) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(INSERT_MANAGERS_SQL);
        preparedStatement.setString(1, manager.getId());
        preparedStatement.setString(2, manager.getFullName());
        preparedStatement.setString(3, manager.getEmail());
        preparedStatement.setString(4, manager.getPassword());

        return preparedStatement.executeUpdate() > 0;
    }

    public List<String> getAllId() throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement(SELECTID_MANAGERS_SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> id = new ArrayList<>();
        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        resultSet.close();
        return id;
    }

    public Manager get(String email, String password) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from Managers m where m.email = ? and m.password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        Manager manager = null;
        if (resultSet.next()) {
            manager = new Manager(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return manager;
    }

    public List<Manager> selectAllUsers(int offset, int noOfRecords){
        List<Manager> list = new ArrayList<>();

        String query = "select SQL_CALC_FOUND_ROWS * from managers limit " + offset + ", " + noOfRecords;
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String ID = rs.getString("id");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String password = rs.getString("password");

                Manager mnager = new Manager(ID,fullName,email,password);
                list.add(mnager);
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

    public boolean deleteManager(String id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_MANAGERS_SQL);
        preparedStatement.setString(1, id);
        rowDeleted = preparedStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    public Manager selectManager(String id) {
        Manager manager = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_MANAGERS_BY_ID);) {
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String password = rs.getString("password");

                manager = new Manager(id, fullName, email, password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return manager;
    }

    public boolean updateManager(Manager manager) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_MANAGERS_SQL);
        preparedStatement.setString(1, manager.getFullName());
        preparedStatement.setString(2, manager.getEmail());
        preparedStatement.setString(3, manager.getPassword());
        preparedStatement.setString(4, manager.getId());

        return preparedStatement.executeUpdate() > 0;

    }
}
