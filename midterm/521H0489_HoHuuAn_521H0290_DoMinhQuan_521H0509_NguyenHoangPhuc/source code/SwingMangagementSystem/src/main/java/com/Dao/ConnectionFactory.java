
package com.Dao ; 
// ConnectionFactory.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(ConnectionConfig.DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        String connectionUrl = ConnectionConfig.CONNECTION_URL + ConnectionConfig.DATABASE_NAME;
        conn = DriverManager.getConnection(connectionUrl, ConnectionConfig.DB_USER, ConnectionConfig.DB_PASSWORD);
        return conn;
    }
    public  ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}