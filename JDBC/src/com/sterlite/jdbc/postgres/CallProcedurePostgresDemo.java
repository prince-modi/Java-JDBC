/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 17-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description
 */
package com.sterlite.jdbc.postgres;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.sterlite.jdbc.connection.DBConnection;

/**
 * @author piirns
 *
 */
public class CallProcedurePostgresDemo {
	public static void main(String[] args) {
		try(Connection con = DBConnection.getDBConnectivity();){
			CallableStatement cstmt = con.prepareCall("CALL update_price(?,?)");
			cstmt.setInt(1, 1111);
			cstmt.setInt(2, 5200);
			cstmt.execute();
			System.out.println("Execution successful!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
