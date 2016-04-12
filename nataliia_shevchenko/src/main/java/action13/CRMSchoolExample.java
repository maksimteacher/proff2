package action13;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import action12.HibernateSimpleExampleQuery;
import dao.SchoolDaoImpl;
import domain.Product;
import domain.School;
import domain.Student;
import util.HibernateUtil;

public class CRMSchoolExample {
	private static Logger log = Logger.getLogger(HibernateSimpleExampleQuery.class);
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<School> list = null;
		try {
			session = factory.openSession();
//			query = session.createSQLQuery("select * from schools join departments on schools.id = departments.school_id " + 
//                    "join students on students.department_id = departments.id " + "where schools.id = :idSchool").addEntity(School.class);
//			query.setInteger("idSchool", 1);
			query = session.createSQLQuery("select * from students join departments on students.department_id = departments.id " + 
                   "join schools on schools.id = departments.school_id " + "where schools.id = :idSchool " + "order by students.name").addEntity(School.class);
			//query.setInteger("b", 7);
			query.setInteger("idSchool", 1);
			list = query.list();
			System.out.println("1="+list);			
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
