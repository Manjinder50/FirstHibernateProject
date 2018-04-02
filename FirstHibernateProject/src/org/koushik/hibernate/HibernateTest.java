package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		/*user.setUserId(1);
		user.setUserName("FirstUser");
*/		
		user.setUserId(2);
		user.setUserName("SecondUser");
		
		//Creating the session Factory
		//buildSessionFactory returns the SessionFactory object
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
				
	   //Create sessions from SessionFactory
		Session session = factory.openSession();
		
		//Begin a new transaction
		session.beginTransaction();
				
	   //Use the session to save model objects
		session.save(user);		
		
		//Get the transaction and commit
		session.getTransaction().commit();
		
		//Close the session
		session.close();
	}

}
