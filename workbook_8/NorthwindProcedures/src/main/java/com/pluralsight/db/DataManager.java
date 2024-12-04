package com.pluralsight.db;

import com.pluralsight.model.CustomerOrderHistory;
import com.pluralsight.model.SaleByCategory;
import com.pluralsight.model.SaleByYear;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private BasicDataSource dataSource;

    public DataManager(String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL CustOrderHist(?)}")) {
            statement.setString(1, customerId);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    int totalQuantity = results.getInt("Total");

                    CustomerOrderHistory orderHistory = new CustomerOrderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orderHistoryList;
    }

    public List<SaleByYear> searchSalesByYear(String startDate, String endDate) {
        List<SaleByYear> salesByYearList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL `Sales By Year`(?, ?)}")) {
            statement.setString(1, startDate);
            statement.setString(2, endDate);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String shippedDate = results.getString("ShippedDate");
                    int orderId = results.getInt("OrderId");
                    double subtotal = results.getDouble("Subtotal");
                    String year = results.getString("Year");

                    SaleByYear saleByYear = new SaleByYear(shippedDate, orderId, subtotal, year);
                    salesByYearList.add(saleByYear);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return salesByYearList;
    }

    public List<SaleByCategory> searchSalesByCategory(String categoryName, String orderYear) {
        List<SaleByCategory> salesByCategoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL SalesByCategory(?, ?)}")) {
            statement.setString(1, categoryName);
            statement.setString(2, orderYear);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String category = results.getString("ProductName");
                    double totalSales = results.getDouble("TotalPurchase");

                    SaleByCategory saleByCategory = new SaleByCategory(category, totalSales);
                    salesByCategoryList.add(saleByCategory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return salesByCategoryList;
    }
}
