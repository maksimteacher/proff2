package action11;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import domain.Contructor;
import util.HibernateUtil;

public class HibernateSimpleExampleContructorsInsert {
	private static Logger log = Logger.getLogger(HibernateSimpleExampleContructorsInsert.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		log.info("Reference to SessionFactory " + factory);

		Session session = null;
		try {
			session = factory.openSession();
			log.info("session opened!");
			session.beginTransaction();

			Contructor contructor = new Contructor("Заказчикс");
			session.save(contructor);

			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Open session failed", e);
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		log.info("session = " + session);
	}
}
