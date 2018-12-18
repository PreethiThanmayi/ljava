package com.capgemini.mps.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

import com.capgemini.mps.exception.MobilePurchaseException;

public class DBConnection {
	private static Connection connection = null;
	private static DBConnection instance = null;
	private static Properties properties = null;
	private static OracleDataSource dataSource = null;
	
	
	private DBConnection() throws MobilePurchaseException {
		try {
			properties = loadProperties();
			dataSource = prepareDataSource();
		} catch (IOException e) {
			throw new MobilePurchaseException(
					" Could not read the database details from properties file ");
		} catch (SQLException e) {
			throw new MobilePurchaseException(e.getMessage());
		}

	}

	private Properties loadProperties() throws IOException {

		if (properties == null) {
			Properties newProperties = new Properties();
			String fileName = "resources/database.properties";

			InputStream inputStream = new FileInputStream(fileName);
			newProperties.load(inputStream);
			inputStream.close();

			return newProperties;
		} else {
			return properties;
		}
	}
/*
 * returns properties object
 * @throws exception
 */
	private OracleDataSource prepareDataSource() throws SQLException {

		if (dataSource == null) {
			if (properties != null) {
				String connectionURL = properties.getProperty("url");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");

				dataSource = new OracleDataSource();

				dataSource.setURL(connectionURL);
				dataSource.setUser(username);
				dataSource.setPassword(password);
			}
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws MobilePurchaseException, SQLException{
		if(connection==null){
			getInstance();
			return dataSource.getConnection();
		}
		return connection;
	} 
	public static DBConnection getInstance() throws MobilePurchaseException {
		synchronized(DBConnection.class){
			if(instance == null){
				instance=new DBConnection();
			}
		}
		return instance;
	}
	
}