package action12;

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

public class HibernateSimpleExampleQuery {
	private static Logger log = Logger.getLogger(HibernateSimpleExampleQuery.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Product> list = null;
		try {
			//
			query = session.createSQLQuery("select * from Product where code between :a and :b")
				.addEntity(Product.class);
				query.setInteger("a", 16);
				query.setInteger("b", 17);
				list = query.list();
			//
			query = session.createSQLQuery("select name from Product where id > ?")
			.addEntity(Product.class);
			query = query.setLong(0, 2);
			list = query.list();
			//
			query = session.createQuery("from Product");
			list = query.list();
			//
			query = session.createQuery("select barcode from Product");
			List<String>  listBarcode = query.list();
			
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
