package ca.blackperl.utils;

import java.net.URL;
import java.net.URLClassLoader;

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
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure("/ca/blackperl/utils/hibernate.cfg.xml")
					.setInterceptor(new AuditInterceptor())
					.buildSessionFactory();

		} catch (Throwable ex) {
			log.error("Error obtaining connection " + ex.getMessage(), ex);
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			while (cl != null) {
				log.debug("ClassLoader: " + cl.getClass().getName());
				URL[] urls = ((URLClassLoader) cl).getURLs();
				for (URL url : urls) {
					log.debug("  " + url.getFile());
				}
				cl = cl.getParent();
			}
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
