package dao;

import java.util.List;

import org.hibernate.HibernateException;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Lecture lecture) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Lecture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findByDep(Long depId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findByStud(Long studentIt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lecture> findBySchool(Long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
