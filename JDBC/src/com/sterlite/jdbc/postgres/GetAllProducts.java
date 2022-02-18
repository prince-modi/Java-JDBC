/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 17-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description
 */
package com.sterlite.jdbc.postgres;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sterlite.jdbc.connection.DBConnection;

/**
 * @author piirns
 *
 */
public class GetAllProducts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DBConnection.getDBConnectivity();){
			//database operations logic
			//Create Statement using Connection
			Statement stmt = con.createStatement();
			
			// Fire the static SQL (embedded SQL) and obtain ResultSet
			ResultSet rs = stmt.executeQuery("select * from product order by id");
			
			// navigate over the ResultSet using cursor
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString("BRAND");
				float price = rs.getFloat("price");
				System.out.println("Product ID: "+id+
						" Name: "+name+
						" Brand: "+brand+
						" Price: "+price);
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
