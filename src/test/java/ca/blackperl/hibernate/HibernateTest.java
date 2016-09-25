package ca.blackperl.hibernate;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.DataSource;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ca.blackperl.dwr.bean.AjaxBean;
import ca.blackperl.utils.HibernateUtil;

public class HibernateTest implements ConnectionEventListener {

	private static final Logger log = LogManager.getLogger(HibernateTest.class);

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
		ds.setCreateDatabase("create");
		ic.bind("java:comp/env/jdbc/eventsDb", ds);

		EmbeddedDataSource toursdb = new EmbeddedDataSource();

		toursdb.setDatabaseName("demo/databases/toursdb");
		ic.bind("java:comp/env/jdbc/toursDb", toursdb);
	}

	private boolean errorOccured = false;
	private boolean connectionClosed = false;

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
					for (String email : p.getEmailAddresses()) {
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
					for (Person p : e.getParticipants()) {
						for (String ea : p.getEmailAddresses()) {

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

	@Test
	public void test5() {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				for (int i = 0; i < 100000; i++) {
					Person p = new Person();
					p.setAge((long) (Math.random() * 40 + 18));
					StringBuffer sb = new StringBuffer();
					String letters = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 0; j < 16; j++) {
						sb.append(letters.charAt((int) Math.floor(Math.random() * letters.length())));
					}
					p.setFirstname(sb.toString());
					sb = new StringBuffer();
					for (int j = 0; j < 16; j++) {
						sb.append(letters.charAt((int) Math.floor(Math.random() * letters.length())));
					}
					p.setLastname(sb.toString());

					Set<String> emailAddresses = new HashSet<String>();
					int emails = (int) (Math.random() * 6 + 1);
					for (int j = 0; j < emails; j++) {
						emailAddresses.add(p.getFirstname() + "." + p.getLastname() + "@" + j + ".example.com");
					}
					p.setEmailAddresses(emailAddresses);
					session.save(p);

					// 20, same as the JDBC batch size
					if (i % 20 == 0) {
						// flush a batch of inserts and release memory:
						session.flush();
						session.clear();
					}
				}
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
				throw e;
			}
		} catch (Exception e) {
			fail("failed: " + e.getMessage());
		}
	}

	@Test
	public void test6() throws Exception {
		try {
			DataSource ds = AjaxBean.getDataSource("toursDb");
			try (Connection connection = ds.getConnection()) {
				// Where Dynamic Parameters Are Allowed
				// You can use dynamic parameters anywhere in an expression
				// where their data type can be easily deduced.

				// As a result the following fails
				try (PreparedStatement ps = connection.prepareStatement("select * from ?")) {
					ps.setString(1, "AIRLINE");
					try (ResultSet tables = ps.executeQuery()) {

					}
				}
			}
			fail("There was no exception - expected SQL to fail because Derby doesn't support ? in from clause");
		} catch (SQLException e) {
			if (e instanceof SQLSyntaxErrorException ) {
				if ( e.getMessage().contains("Syntax error: Encountered \"?\"")) {
					// pass
				}
				else {
					fail("new error" + e.getMessage());
				}
			}
			else {
				log.error(e,e);
			}
		} catch (Exception e) {
			log.error(e,e);
		}
	}

	@Ignore
	@Test
	public void test7() throws Exception {
		try {
			DataSource ds = AjaxBean.getDataSource("toursDb");
			List<Connection> connections = new ArrayList<Connection>();
			try {
				for (int i = 0; i < 1000; i++) {
					Connection connection = ds.getConnection();
					connections.add(connection);
				}
			} catch (Exception e) {
				for (int i = 0; i < connections.size(); i++) {
					connections.get(i).close();
				}
			}
		} catch (Exception e) {
		}
	}

	@Test
	public void explain() throws Exception {
		try {
			DataSource ds = AjaxBean.getDataSource("eventsDb");
			try (Connection connection = ds.getConnection()) {
				List<String> statements = Arrays.asList(new String[] {
						"-- turn on RUNTIMESTATISTICS for connection: \n"
								+ "CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1)",
						"CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1)",
						"-- Indicate that statistics information should be captured into \n"
								+ "-- database tables in the MYSCHEMA schema: \n"
								+ "CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('APP')",
								"call SYSCS_UTIL.SYSCS_SET_XPLAIN_MODE(1)",
								"select * from Person",
								"call SYSCS_UTIL.SYSCS_SET_XPLAIN_MODE(0)",
								"select stmt_text, xplain_time from sysxplain_statements order by xplain_time",
						"--execute queries, step through result sets, perform application processing... \n"
								+ "CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0)",
								});
				int results = 0;
				int updates = 0;

				for (String sql : statements) {
					try (PreparedStatement stmt = connection.prepareStatement(sql)) {
						log.debug("Running SQL:\n" + sql);
						boolean resultForm = stmt.execute();
						while (true) {
							if (resultForm) {
								results++;
								try (ResultSet result = stmt.getResultSet()) {
									if ( result == null ) {
										log.debug("no more results");
										break;
									}
									ResultSetMetaData metaData = result.getMetaData();
									
									while (result.next()) {
										List<String> cols = new ArrayList<String>();
										for (int i = 1; i <= metaData.getColumnCount(); i++) {
											cols.add(result.getString(i));
										}
										System.out.println(cols);
									}
								}
							} else {
								updates++;
								int updateCount = stmt.getUpdateCount();
								if (updateCount == -1) {
									log.debug("no more results");
									break;
								}
								log.debug("Updated " + updateCount);
							}
							resultForm = stmt.getMoreResults();
						}
					} catch (Exception e) {
						log.error("Error processing SQL: " + e + "\n" + sql, e);
					}
				}
				log.info("Results=" + results + " Updates=" + updates);
			}
		} catch (Exception e) {
			log.error(e, e);
		}
	}

	@Override
	public void connectionClosed(ConnectionEvent event) {
		connectionClosed = true;
	}

	@Override
	public void connectionErrorOccurred(ConnectionEvent event) {
		errorOccured = true;
	}
}
