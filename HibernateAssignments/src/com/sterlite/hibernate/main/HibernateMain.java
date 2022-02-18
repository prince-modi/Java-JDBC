/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description Demonstrates Hibernate Components and Database Operations using ORM
 */
package com.sterlite.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sterlite.hibernate.entities.Product;

/**
 * @author piirns
 *
 */
public class HibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Create configuration Object
		// Step1
		Configuration cfg = new Configuration();
		// TODO Read Hibernate Configuration from hibernate.cfg.xml
		// Step2
		Configuration c = cfg.configure();
		// TODO Load All read configurations in SessionFactory and obtain it OR Build SessionFactory using read configuration and obtain to SessionFactory
		// Step3
		// Heavyweight and Singleton Object
		SessionFactory sf = c.buildSessionFactory();
		// TODO Obtain Session from Session Factory
		// Step 4
		// Session represents database connection
		// Session provides CRUD methods to perform database operations
		// Lightweight and Not Singleton Object
		Session ss = sf.openSession();
		// TODO Obtain Transaction from Session
		// Step 5
		// Start the Transaction
		Transaction tx = ss.beginTransaction();
		// TODO Perform Database Operations
		// Step 6
		// SELECT,INSERT,UPDATE,DELETE, or DML operations using ORM
		
			// get a row as per primary key in the form of object
		Product p = ss.get(Product.class, 1001); //persistent state
		System.out.println(p);
		
			// add a product object as a row in database table
//		Product p1 = new Product(); //transient state
//		p1.setProductId(9101);
//		p1.setProductName("Speaker");
//		p1.setBrand("Sennhiezer");
//		p1.setPrice(45000);
//		
//		ss.save(p1); //after saving Product p1 will be in persistent state
		
			// update existing row using object of Persistent class
//		Product p2 = ss.get(Product.class, 9100);
//		if(p2!=null) {
//			p2.setPrice(p.getPrice()+1000);
//			p2.setBrand("Sennheiser");
//			ss.update(p2);
//		}else
//			System.out.println("Product not found.");
		
		// TODO Commit Transaction
		// Step 7
		tx.commit();
		// TODO Close Session
		// Step 8
		ss.close();
	}

}
