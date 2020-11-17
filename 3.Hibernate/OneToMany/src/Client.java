import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import oracle.net.TNSAddress.Address;


public class Client {
	
	private static SessionFactory factory;
	
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Set<Student> vStd = new HashSet<Student>();
			Set<Student> cStd = new HashSet<Student>();
			Set<Student> kStd = new HashSet<Student>();
			Set<Student> mStd = new HashSet<Student>();
			vStd.add(new Student(259, "Mohammed Taqueeuddin"));
			vStd.add(new Student(250, "Mohammed Uzair Mohiuddin"));
			kStd.add(new Student(254, "Mohit Shah"));
			kStd.add(new Student(256, "Vamshi Reddy"));
			cStd.add(new Student(208, "Neha Karan"));
			cStd.add(new Student(251, "Rashmika"));
			mStd.add(new Student(224, "PV Rohit"));
			mStd.add(new Student(232, "Jashwanth Reddy"));

			College vmeg = new College("VMEG", "Vardhaman College Of Engineering",vStd);
			College cbit = new College("JNTUH", "JawaharLal Nehru Technological University",jStd);
			College mvsr = new College("VNR", "Vignana Jyothi Institute Of Technology",vStd);
			College kmit = new College("MLRIT", "Malla Reddy Institute Of Technology",mStd);

			session.save(vmeg);
			session.save(jntuh);
			session.save(vnr);
			session.save(mlrit);
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();

		List stdList = session.createQuery("From Student_otm").list();
		display(stdList);
		List clgList = session.createQuery("From College").list();
		display(clgList);
		List clgstd = session.createQuery("From clgstd").list();
		display(clgstd);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			College clg = (College) iterator.next();
			System.out.println(clg.toString());
		}
	}
	
	
}
