package com.pluralsight.NothwindTradersSpringBoot4.dao.impl;

import com.pluralsight.NothwindTradersSpringBoot4.dao.interfaces.IProductDAO;
import com.pluralsight.NothwindTradersSpringBoot4.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDAO implements IProductDAO {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDAO(DataSource dataSource){
        this.dataSource = dataSource;
        //initialize();
    }

    private void initialize(){
        // This method sets up the database table and populates it with initial data if necessary.
        try (Connection connection = dataSource.getConnection()) {
            // SQL statement to create a transactions table if it does not exist.
            String createTableQuery = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "transaction_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "amount DECIMAL(10, 2) NOT NULL," +
                    "vendor VARCHAR(255) NOT NULL" +
                    ")";
            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableQuery)) {
                createTableStatement.execute(); // Execute the table creation query.
            }

            // Check if the table has any data already.
            String countQuery = "SELECT COUNT(*) AS rowCount FROM transactions";
            try (PreparedStatement countStatement = connection.prepareStatement(countQuery);
                 ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt("rowCount") == 0) {
                    // Insert initial data if the table is empty.
                    String insertDataQuery = "INSERT INTO transactions (amount, vendor) VALUES (?, ?)";
                    try (PreparedStatement insertDataStatement = connection.prepareStatement(insertDataQuery)) {
                        // Insert first transaction.
                        insertDataStatement.setDouble(1, 2000.00);
                        insertDataStatement.setString(2, "Raymond");
                        insertDataStatement.executeUpdate();

                        // Insert second transaction.
                        insertDataStatement.setDouble(1, 2500.00);
                        insertDataStatement.setString(2, "John");
                        insertDataStatement.executeUpdate();

                        // Insert third transaction.
                        insertDataStatement.setDouble(1, 4000.00);
                        insertDataStatement.setString(2, "Jane");
                        insertDataStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
    }
    @Override
    public void add(Product product) {
        // This method adds a new product to the database.
        String insertDataQuery = "INSERT INTO products (ProductID, ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(insertDataQuery, Statement.RETURN_GENERATED_KEYS)) {
            // Setting parameters for the insert query.
            insertStatement.setInt(1, product.getProductId());
            insertStatement.setString(2, product.getName());
            insertStatement.setInt(3,product.getCategory());
            insertStatement.setDouble(4, product.getPrice());
            int affectedRows = insertStatement.executeUpdate(); // Execute the insert query.

            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    product.setProductId(generatedId);
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }

        //return product;
    }

    @Override
    public List<Product> getAll() {
        // This method retrieves all products from the database.
        List<Product> products = new ArrayList<>();
        String getAllQuery = "SELECT * FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(getAllQuery);
             ResultSet resultSet = selectStatement.executeQuery()) {
            while (resultSet.next()) {
                // Extract data from each row in the result set.
                int productId = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                int catId = resultSet.getInt("CategoryID");
                double price = resultSet.getDouble("UnitPrice");
                // Create a Product object and add it to the list.
                products.add(new Product(productId, productName, catId,price));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception.
        }
        return products; // Return the list of products.
    }
}
