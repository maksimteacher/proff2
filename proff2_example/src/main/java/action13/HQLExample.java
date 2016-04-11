package action13;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Contructor;
import domain.Product;
import util.HibernateUtil;

public class HQLExample {
	private static Logger log = Logger.getLogger(HQLExample.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Product> list = null;
		try {
			session = factory.openSession();
			// HQL
			String v = "user_";
			query = session.createQuery("from User where name like "+ v);
			query = session.createQuery("from User where name like :name")
					.setParameter("name", "user_");
			list = query.list();
			System.out.println(list);
		} catch (HibernateException e) {
			log.error("Open session failed", e);
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
