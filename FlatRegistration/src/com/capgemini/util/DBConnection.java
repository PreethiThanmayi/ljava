package com.capgemini.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;



import com.capgemini.exception.FlatException;

public class DBConnection {
	
	private static Connection connection = null;
	private static DBConnection instance = null;
	private static Properties properties = null;
	private static OracleDataSource oracleDataSource = null;
	/**
	 * loads database.properties file and Driver Class and get connection
	 * @throws ARSException
	 */
	private DBConnection() throws FlatException  {
		try {
			properties = loadProperties();
			oracleDataSource = prepareDataSource();
		} catch (IOException e) {
			throw new FlatException(
					" Could not read the database details from properties file ");
		} catch (SQLException e) {
			throw new FlatException(e.getMessage());
		}

	}
	/**
	 * 
	 * @return returns Properties object
	 * @throws IOException
	 * loading the data in properties file to Properties object
	 */
	private Properties loadProperties() throws IOException {

		if (properties == null) {
			Properties newProperties = new Properties();
			String fileName = "resources\\database.properties";

			InputStream inputStream = new FileInputStream(fileName);
			newProperties.load(inputStream);

			inputStream.close();

			return newProperties;
		} else {
			return properties;
		}
	}
	/**
	 * 
	 * @return OracleDataSource object
	 * @throws SQLException
	 */
	private OracleDataSource prepareDataSource() throws SQLException {

		if (oracleDataSource == null) {
			if (properties != null) {
				String connectionURL = properties.getProperty("url");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");

				oracleDataSource = new OracleDataSource();

				oracleDataSource.setURL(connectionURL);
				oracleDataSource.setUser(username);
				oracleDataSource.setPassword(password);
			}
		}
		return oracleDataSource;
	}
	/**
	 * 
	 * @return connection
	 * @throws ARSException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws FlatException, SQLException{
		if(connection==null){
			if(instance == null){
			DBConnection instance = new DBConnection();
		}
			return oracleDataSource.getConnection();
		}
		return connection;
	}

}
