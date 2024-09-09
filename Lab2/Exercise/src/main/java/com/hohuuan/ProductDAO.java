package com.hohuuan;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product, Integer> {
    private Connection con;
    public ProductDAO(String url) throws SQLException {
        con = DriverManager.getConnection(url);
    }

    @Override
    public Integer add(Product item) throws SQLException {
        String query = "INSERT INTO products (name, price, color, brand, description, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
        statement.setString(1, item.getName());
        statement.setInt(2, item.getPrice());
        statement.setString(3, item.getColor());
        statement.setString(4, item.getBrand());
        statement.setString(5, item.getDescription());
        statement.setInt(6, item.getQuantity());

        return statement.executeUpdate();
    }

    @Override
    public List<Product> readAll() {
        try {
            String query = "select * from products";
            Statement stm = null;
            stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery(query);

            List<Product> products = new ArrayList<>();
            while( resultSet.next() ){
                products.add(new Product(   resultSet.getInt(1),
                                            resultSet.getString(2),
                                            resultSet.getInt(3),
                                            resultSet.getString(4),
                                            resultSet.getString(5),
                                            resultSet.getString(6),
                                            resultSet.getInt(7)));
            }
            resultSet.close();
            stm.close();
            return products;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Product read(Integer id) throws SQLException {
        try {
            String query = String.format("SELECT * FROM products WHERE id = %d", id);
            PreparedStatement preparedStatement = con.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7));
                resultSet.close();
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean update(Product item) {
        try {
            String sql = "UPDATE products SET name = ?, price = ?, color = ?, brand = ?, description = ?, quantity = ? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getPrice());
            preparedStatement.setString(3, item.getColor());
            preparedStatement.setString(4, item.getBrand());
            preparedStatement.setString(5, item.getDescription());
            preparedStatement.setInt(6, item.getQuantity());
            preparedStatement.setInt(7, item.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id)  {
        try {
            String query = String.format("DELETE FROM products WHERE id = %d;", id);
//            For database
//            DELIMITER //
//            CREATE PROCEDURE reset_auto_increment()
//            BEGIN
//            DECLARE max_id INT;
//
//            -- Step 1: Find the maximum value of the column 'id'
//            SELECT MAX(id) INTO max_id FROM products;
//
//            -- Step 2: Set the auto-increment value
//            SET @sql = CONCAT('ALTER TABLE products AUTO_INCREMENT = ', max_id + 1);
//            PREPARE stmt FROM @sql;
//            EXECUTE stmt;
//            DEALLOCATE PREPARE stmt;
//            END //
//            DELIMITER ;
            PreparedStatement preparedStatement = con.prepareStatement(query);

            String sql = "CALL reset_auto_increment();";
            Statement stm = con.createStatement();
            stm.executeQuery(sql);
            return preparedStatement.executeUpdate() == 1;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public  void resetAutoIncrement(){
        String sql = "CALL reset_auto_increment();";
        Statement stm = null;
        try {
            stm = con.createStatement();
            stm.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws SQLException {
        con.close();
    }
}
