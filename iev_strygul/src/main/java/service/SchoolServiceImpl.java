package service;

import java.util.List;

import org.hibernate.HibernateException;

import dao.SchoolDao;
import dao.SchoolDaoImpl;
import domain.School;

public class SchoolServiceImpl implements SchoolService {
	private static SchoolDao dao;

	public SchoolServiceImpl() {
		dao = new SchoolDaoImpl();
	}


	@Override
	public School getSchool(Long id) {
		School school = null;
		try {
			school = dao.getSchool(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return school;
	}

	@Override
	public void addSchool(School school) {
		try {
			dao.addSchool(school);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSchool(School school) {
		try {
			dao.update(school);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSchool(School school) {
		try {
			dao.delete(school);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<School> getAllSchools() {
		List<School> list = null;
		try {
			list = dao.getSchools();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
