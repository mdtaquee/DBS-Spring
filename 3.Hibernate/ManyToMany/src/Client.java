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

			Student taq = new Student(259, "Mohammed Taqueeuddin");
			Student uzr = new Student(224, "Mohammed Uzair");
			Student moh = new Student(208, "Mohit Shah");
			Student vam = new Student(232, "VAmshi Reddy");
			
			Set<Student> shift1 = new HashSet<Student>();
			shift1.add(moh);
			shift1.add(vam);
			
			Set<Student> shift2 = new HashSet<Student>();
			shift2.add(taq);
			shift2.add(uzr);
						
			Teacher tir = new Teacher(1, "C", "Tirupati", shift2);
			Teacher she = new Teacher(2, "Java", "Shekar", shift1);
			Teacher rag = new Teacher(3, "CNS", "Raghu", shift2);
			Teacher shi = new Teacher(4, "Linux", "Shivani", shift1);

			session.save(tir);
			session.save(she);
			session.save(rag);
			session.save(shi);
			
			tx.commit();
			c.displayRecords();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		Session session = factory.openSession();
		List tchList = session.createQuery("From Teacher").list();
		display(tchList);
		session.close();
	}
	
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	
	
}
