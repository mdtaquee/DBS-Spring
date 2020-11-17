import java.util.*;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class Client {
	
	private static SessionFactory factory;
	
	//Obtain session factory
	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder =  new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			getSessionFactory();
			Client client_1 = new Client();
			
			Address add1 = new Address("Flemingo Road","Washington DC","USA","532");
			Employee emp1 = new Employee(3,"Charan","Kumar",4000);
			emp1.setAddress(add1);
			client_1.insertData(emp1, add1);
			
			Address add2 = new Address("RR Nagar","Bangalore","India","560098");
			Employee emp2 = new Employee(4,"Rajesh", "Mehta", 4000);
			emp2.setAddress(add2);
			client_1.insertData(emp2, add2);
			
			try {
				client_1.displayRecords();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	public void insertData(Employee empObj, Address addObj)
	{
		
		Session session = factory.openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		session.save(empObj);
		session.save(addObj);
		tx.commit();
		
		System.out.println("Employees and Address are inserted in the database:");
		session.close();
	}
	
	public void displayRecords( ) throws InterruptedException {
		Session session = factory.openSession();
		
		List employees = session.createQuery("FROM Employee").list();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
			System.out.println("First Name: " + employee.getSalary());
			Address add = employee.getAddress();
			System.out.println("First Name: " + add.getStreet());
			System.out.println("First Name: " + add.getState());
			System.out.println("First Name: " + add.getCity());
			System.out.println("First Name: " + add.getZipcode());
		}
		
		session.close();
	}
	
}