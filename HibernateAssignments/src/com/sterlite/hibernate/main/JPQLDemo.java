/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description Demonstrates JPQL using hibernate
 */
package com.sterlite.hibernate.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sterlite.hibernate.entities.Product;

/**
 * @author piirns
 *
 */
public class JPQLDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		Configuration c = cfg.configure();
		SessionFactory sf = c.buildSessionFactory();
		Session ss = sf.openSession();
		
								// JPQ
//		Query q = ss.createQuery("from Product");
//		Query q = ss.createQuery("from Product where name like 'S%' ");
//		Query q = ss.createQuery("from Product where name like 'S%' order by ID ");
//		List<Product> products = q.getResultList();
//		products.forEach((p)->System.out.println(p));
		
//		Query q = ss.createQuery("select p.productName,p.price from Product p");
//		List<Object[]> rows = q.getResultList();
//		for (int i = 0; i<rows.size();i++) {
//			Object[] objects = rows.get(i);
//			System.out.println(objects[0]+" "+objects[1]);}
		
		
//		Query q = ss.createQuery("select count(*) from Product");
//		long rowCount = (long) q.getSingleResult();
//		System.out.println(rowCount);
		
		Query q = ss.createQuery("select max(p.price) from Product p");
		float maxPrice = (float) q.getSingleResult();
		System.out.println(maxPrice);
		
		ss.close();

	}

}
