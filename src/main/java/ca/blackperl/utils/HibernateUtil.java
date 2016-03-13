package ca.blackperl.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final Logger log = LogManager.getLogger(HibernateUtil.class);

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure("/ca/blackperl/utils/hibernate.cfg.xml")
					.setInterceptor(new AuditInterceptor())
					.buildSessionFactory();
		} catch (Throwable ex) {
			log.debug("Error obtaining connection " + ex.getMessage());
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
