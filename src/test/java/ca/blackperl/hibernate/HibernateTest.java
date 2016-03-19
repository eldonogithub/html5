package ca.blackperl.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.blackperl.utils.HibernateUtil;

public class HibernateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
		InitialContext ic = new InitialContext();

		ic.createSubcontext("java:");
		ic.createSubcontext("java:comp");
		ic.createSubcontext("java:comp/env");
		ic.createSubcontext("java:comp/env/jdbc");

		// Construct DataSource
		EmbeddedDataSource ds = new EmbeddedDataSource();
		ds.setDatabaseName("eventsDb");

		ic.bind("java:comp/env/jdbc/eventsDb", ds);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Query createQuery = session.createQuery("from Event");
				List<Event> list = createQuery.list();
				for (Event e : list) {
					e.getId();
				} 
			} finally {
				session.close();
			}
			
		} catch (Exception e) {
			fail("failed: " + e.getMessage());
		}
	}

	@Test
	public void test2() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Query createQuery = session.createQuery("from Person");
				List<Person> list = createQuery.list();
				for (Person p : list) {
					p.getId();
				} 
			} finally {
				session.close();
			}
			
		} catch (Exception e) {
			fail("failed: " + e.getMessage());
		}
	}

	@Test
	public void test3() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Query createQuery = session.createQuery("from Person");
				List<Person> list = createQuery.list();
				for (Person p : list) {
					p.getId();
					for ( String email : p.getEmailAddresses() ) {
					}
				} 
			} finally {
				session.close();
			}
			
		} catch (Exception e) {
			fail("failed: " + e.getMessage());
		}
	}

	@Test
	public void test4() {
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			try {
				Query createQuery = session.createQuery("from Event");
				List<Event> list = createQuery.list();
				for (Event e : list) {
					e.getId();
					for( Person p: e.getParticipants() ) {
						for ( String ea : p.getEmailAddresses() ) {
							
						}
					}
				} 
			} finally {
				session.close();
			}
			
		} catch (Exception e) {
			fail("failed: " + e.getMessage());
		}
	}

}
