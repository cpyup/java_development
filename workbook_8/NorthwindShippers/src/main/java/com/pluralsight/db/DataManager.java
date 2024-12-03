package com.pluralsight.db;

import com.pluralsight.model.Shipper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertIntoWithGeneratedKeys(Shipper shipper) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into shippers (CompanyName,Phone) values (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, shipper.getCompanyName());
            preparedStatement.setString(2, shipper.getPhoneNumber());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Inserted: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.println("Generated Shipper ID: " + keys.getInt(1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Shipper> getAllShippers(){
        List<Shipper> shippers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM shippers")) {

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    int shipperId = results.getInt("ShipperID");
                    String companyName = results.getString("CompanyName");
                    String companyPhone = results.getString("Phone");

                    Shipper shipper = new Shipper(shipperId, companyName, companyPhone);
                    shippers.add(shipper);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shippers;
    }

    public void deleteRecord(Shipper shipper) {
        if(shipper.getShipperId() <= 3)return;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM shippers WHERE ShipperID = ?")) {
            preparedStatement.setInt(1, shipper.getShipperId());

            int rows = preparedStatement.executeUpdate();
            System.out.println("Rows Deleted: " + rows);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateRecord(String newNumber, int shipperId) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE shippers SET Phone = ? WHERE ShipperID = ?")) {
            preparedStatement.setString(1, newNumber);
            preparedStatement.setInt(2, shipperId);

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows Updated: " + rows);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
