package action13;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Student;
import domain.Department;
import domain.School;
import util.HibernateUtil;

public class SchoolTest {
	private static Logger log = Logger.getLogger(SchoolTest.class);
	public static void main(String[] args) {

		//-Получение списка всех учеников школы, в отсортированном виде по имени.
		
		Locale.setDefault(Locale.ENGLISH);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Student> list = null;
		try {
			session = factory.openSession();
			//-Получение списка учеников по id класса.
			query = session.createSQLQuery("select * from students where department_id = 1")
					.addEntity(Student.class);
			//query.setInteger("a", 1);
			list = query.list();
			System.out.println("1="+list);
			//-Получение списка классов по id школы.
			query = session.createSQLQuery("select name from departments where school_id = 1");
			//query = query.setLong(0, 2);
			//query = query.setLong(1, 4);
			List<String> str = query.list();
			System.out.println("2="+str);
			query = session.createSQLQuery("select * from students where department_id = 1 order by login")
					.addEntity(Student.class);
			//query.setInteger("a", 1);
			list = query.list();
			System.out.println("3="+list);
			// HQL
			/*query = session.createQuery("from Product");
			list = query.list();
			System.out.println("3="+list);
			//
			query = session.createQuery("select barcode from Product");
			List<String> listBarcode = query.list();
			System.out.println("4="+listBarcode);*/
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
