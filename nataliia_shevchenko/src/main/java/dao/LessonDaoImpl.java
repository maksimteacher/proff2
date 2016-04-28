package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import domain.Lesson;
import util.HibernateUtil;

public class LessonDaoImpl implements LessonDao {
	private static Logger log = Logger.getLogger(LessonDaoImpl.class);

	@Override
	public Long create(Lesson lesson) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(lesson);
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
	public Lesson read(Long idLesson) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Lesson lesson = null;
		try {
			lesson = (Lesson)session.get(Lesson.class, idLesson);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return lesson;
	}

	@Override
	public void update(Lesson lesson) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(lesson);
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
	public void delete(Lesson lesson) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(lesson);
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
	public List<Lesson> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Query query = session.createQuery("from Lesson");
			return query.list();
		} finally {
			session.close();
		}
	}

}
