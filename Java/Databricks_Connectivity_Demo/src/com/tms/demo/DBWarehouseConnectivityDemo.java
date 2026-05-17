package com.tms.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


// added --add-opens=java.base/java.nio=DatabricksJDBC42,ALL-UNNAMED in var args while RUN
public class DBWarehouseConnectivityDemo {
	public static void main(String[] args) {
//		connectToDatabricksSQLWarehouse();
		System.out.println("********** GET CATEGORY WISE DATA FROM GOLD STORAGE **********");
		getStoresGoldDataByCategory();
		
		System.out.println("\n********** GET CATEGORY WISE DATA FROM GOLD STORAGE **********");
		getStoresGoldDataByLocation();
	}

	private static Connection getDBDriverConnection() {
		String url = "<jdbc path here>";
		Properties properties = new Properties();
		properties.put("PWD", "<token-here>");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			System.out.println("EXCEPTION MESSAFE : " + e.getMessage());
			System.out.println("EXCEPTION STACKTRACE : " + e.getStackTrace());
		}
		return connection;
	}

	public static void connectToDatabricksSQLWarehouse() {
		try (Connection connection = getDBDriverConnection()) {
			if (connection != null) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SHOW SCHEMAS");
				while (resultSet.next()) {
					System.out.println(resultSet.getString("databaseName"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void getStoresGoldDataByCategory() {
		try (Connection connection = getDBDriverConnection()) {
			if (connection != null) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM stores_gold.category_profit cp ;");
				ResultSetMetaData meta = resultSet.getMetaData();
				int columnCount = meta.getColumnCount();

				for (int i = 1; i <= columnCount; i++) {
				    System.out.print(meta.getColumnLabel(i) + "   \t");
				}
				System.out.println();
			 

				while (resultSet.next()) {
				    for (int i = 1; i <= columnCount; i++) {
				        System.out.print(resultSet.getString(i) + "   \t");
				    }
				    System.out.println();
				  
				}

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public static void getStoresGoldDataByLocation() {
		try (Connection connection = getDBDriverConnection()) {
			if (connection != null) {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM stores_gold.location_profit ;");
				ResultSetMetaData meta = resultSet.getMetaData();
				int columnCount = meta.getColumnCount();
				
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(meta.getColumnLabel(i) + "   \t");
				}
				System.out.println();
				
				
				while (resultSet.next()) {
					for (int i = 1; i <= columnCount; i++) {
						System.out.print(resultSet.getString(i) + "   \t");
					}
					System.out.println();
					
				}
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
