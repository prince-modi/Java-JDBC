/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 16-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description Inserting records to the database using JDBC
 */
package com.sterlite.jdbc.oracle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.sterlite.jdbc.connection.DBConnection;

/**
 * @author piirns
 *
 */
public class AddProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 //con = null;
		try(Scanner sc = new Scanner(System.in);Connection con = DBConnection.getDBConnectivity();){
			//precompiled sql query, parameterzied sql query
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
			con.setAutoCommit(false);
			
			System.out.print("Enter ID:");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			
			System.out.print("Enter Name:");
			sc.nextLine();
			String name = sc.nextLine();
			pstmt.setString(2, name);
			
			System.out.print("Enter Brand:");
			String brand = sc.nextLine();
			pstmt.setString(3, brand);
			
			System.out.print("Enter Price:");
			int price = sc.nextInt();
			pstmt.setInt(4, price);
			
			//Dynamic SQL Query
			int check = pstmt.executeUpdate();
			con.commit();
			System.out.println(check+" row inserted in product");
			
		} catch (ClassNotFoundException e) {
			//con.rollback();
			e.printStackTrace();
		} catch (SQLException e) {
			//con.rollback();
			e.printStackTrace();
		} catch (IOException e) {
			//con.rollback();
			e.printStackTrace();
		}

	}

}
