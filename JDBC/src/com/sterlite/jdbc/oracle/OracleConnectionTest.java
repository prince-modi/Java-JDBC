/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description
 */
package com.sterlite.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author piirns
 *
 */
public class OracleConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			//step1: Load JDBC Driver TYPE IV for Oracle (optional)
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("JDBC Driver loaded");
			
			//step2: Establish Database Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
			System.out.println("Oracle Database connection is established");
			//logic to perform database operations
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
