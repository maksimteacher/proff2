package dao;

import java.util.List;
import domain.School;

public interface SchoolDao {
	Long create(School school);
	School read(Long idSchool);
    void update(School school);
    void delete(School school);
    List<School> findAll();
    List<School> findAllUsersForEachSchool(Long idSchool);
    List<School> findAllDepartmentsForSchool(Long idSchool);

}
