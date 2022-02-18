/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description Database Connectivity Code
 */
package com.sterlite.jdbc.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author piirns
 *
 */
public class DBConnection {
	
	public static Connection getDBConnectivity() throws IOException, ClassNotFoundException, SQLException {
		
		//Create an object of Properties class
		Properties props = new Properties();
		
		//Create FileReader to open properties file in read mode
		FileReader fr = new FileReader("dbconfig.properties");
		
		//load database properties from file into Properties object
		props.load(fr);
		
		//retrieve jdbc properties stored in properties object
		//String driverClassName = props.getProperty("jdbc-driver");
		String jdbcUrl = (String) props.get("jdbc-url");
		String dbUser = props.getProperty("db-username");
		String dbPass = props.getProperty("db-password");
		
		//props.setProperty("db-password", "piirns");
		
		//Optional Load JDBC Driver
		//Class.forName(driverClassName);
		//System.out.println("JDBC Driver Loaded");
		//Establish Database Connection
		Connection con = DriverManager.getConnection(jdbcUrl,dbUser,dbPass);
		System.out.println("Database connection established");
		return con;
	}

}
