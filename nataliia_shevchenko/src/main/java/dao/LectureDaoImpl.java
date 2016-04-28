package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Lecture;
import domain.Score;
import domain.Student;
import util.HibernateUtil;

public class LectureDaoImpl implements LectureDao {
	private static Logger log = Logger.getLogger(LectureDaoImpl.class);

	@Override
	public Long create(Lecture lecture) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(lecture);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public Lecture read(Long idLecture) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Lecture lecture = null;
		try {
			lecture = (Lecture)session.get(Lecture.class, idLecture);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return lecture;
	}

	@Override
	public void update(Lecture lecture) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(lecture);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}	
	}

	@Override
	public void delete(Lecture lecture) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(lecture);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}	
	}

	@Override
	public List<Lecture> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Lecture");
			return query.list();
		} finally {
			session.close();
		}	
	}

	@Override
	public List<Lecture> findAllLecturesWhichWereIssuedForDepartment(Long idDepart) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Lecture> list = null;
		try {
			session = factory.openSession();
			query = session.createSQLQuery("select * from lectures "  
			+ "join lessons on lectures.id = lessons.lecture_id "		
			+ "where lessons.department_id = :id").addEntity(Lecture.class);
			query.setLong("id", idDepart);
			list = query.list();
			System.out.println("List of lectures which were issued to the particular school: " + list);			
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
		return list;
	}

	@Override
	public List<Lecture> findAllLecturesWhichWereIssuedForStudent(Long idStudent) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Lecture> list = null;
		try {
			session = factory.openSession();
			query = session.createSQLQuery("select * from lectures "  
			+ "join lessons on lectures.id = lessons.lecture_id "
			+ "join scores on lessons.id = scores.lesson_id "			
			+ "where scores.student_id = :id").addEntity(Lecture.class);
			query.setLong("id", idStudent);
			list = query.list();
			System.out.println("List of lectures which were issued to the particular school: " + list);			
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
		return list;
	}

	@Override
	public List<Lecture> findAllLecturesWhichWereIssuedForSchool(Long idSchool) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Query query = null;
		List<Lecture> list = null;
		try {
			session = factory.openSession();
			query = session.createSQLQuery("select * from lectures "  
			+ "join lessons on lectures.id = lessons.lecture_id "
			+ "join scores on lessons.id = scores.lesson_id "
			+ "join students on students.id = scores.student_id "
			+ "join departments on departments.id = students.department_id "
			+ "where departments.school_id = :id").addEntity(Lecture.class);
			query.setLong("id", idSchool);
			list = query.list();
			System.out.println("List of lectures which were issued to the particular school: " + list);			
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
		return list;
	}

}
