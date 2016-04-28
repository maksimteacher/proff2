package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Lesson;
import util.HibernateUtil;

public class LessonDaoImpl implements LessonDao{

	@Override
	public Long create(Lesson lesson) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			Transaction tx = session.beginTransaction();
			id = (Long) session.save(lesson);
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
	public Lesson read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Lesson lesson) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Lesson lesson) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lesson> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findByDep(Long depId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findByStud(Long studentIt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findBySchool(Long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
