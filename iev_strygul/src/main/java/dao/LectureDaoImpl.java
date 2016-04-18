package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Lecture;
import util.HibernateUtil;

public class LectureDaoImpl implements LectureDao {
	

	@Override
	public Long create(Lecture lecture) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			Transaction tx = session.beginTransaction();
			id = (Long) session.save(lecture);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public Lecture read(Long id) {
		Lecture lecture = null;
		Session session = HibernateUtil.getSession();
		try {
			lecture = (Lecture)session.get(Lecture.class, id);
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return lecture;
	}

	@Override
	public void update(Lecture lecture) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			Transaction tx = session.beginTransaction();
			session.update(lecture);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Lecture lecture) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			Transaction tx = session.beginTransaction();
			session.delete(lecture);
			tx.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<Lecture> findAll() {
		List<Lecture> lectures = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("from Lecture");
			lectures = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return lectures;
	}

	@Override
	public List<Lecture> findByDep(Long depId) {
		List<Lecture> lectures = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createSQLQuery("SELECT * FROM lectures " +
					"JOIN TABLE lectures_departments ON lectures_departments.lectures_id = lectures.id " +
					"WHERE lectures_departments.departments_id = :id").addEntity(Lecture.class);
			query.setLong("id", depId);
			lectures = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return lectures;
	}

	@Override
	public List<Lecture> findByStud(Long studentId) {
		List<Lecture> lectures = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createSQLQuery("SELECT * FROM lectures " +
					"JOIN TABLE lectures_students ON lectures_students.lectures_id = lectures.id " +
					"WHERE lectures_students.students_id = :id").addEntity(Lecture.class);
			query.setLong("id", studentId);
			lectures = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return lectures;
	}

	@Override
	public List<Lecture> findBySchool(Long schoolId) {
		List<Lecture> lectures = null;
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createSQLQuery("SELECT * FROM lectures " +
					"JOIN lectures_departments ON lectures_departments.lectures_id = lectures.id " +
					"WHERE departments_id IN (SELECT id FROM departments WHERE schools_id = :id)").addEntity(Lecture.class);
			query.setLong("id", schoolId);
			lectures = query.list();
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return lectures;
	}

}
