package Action11.domain;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSimpleExampleContructorsInsert {
    private static Logger log = Logger.getLogger(HibernateSimpleExampleContructorsInsert.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            log.info("session opened!");
            session.beginTransaction();

            Product product = new Product("YOgurt", "bar1");
            Product product2 = new Product("YOgurt", "bar1");
            Product product3 = new Product("YOgurt", "bar1");
            session.save(product);
            session.save(product2);
            session.save(product3);

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
        log.info(session);
    }
}
