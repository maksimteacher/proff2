package dao;

import java.sql.SQLException;
import java.util.List;

import domain.School;

public interface SchoolDao {
	Long addSchool(School school) throws SQLException;
	School getSchool(Long id) throws SQLException;
	List<School> getSchools() throws SQLException;
	void update(School school) throws SQLException;
	void delete(School school) throws SQLException;
}
