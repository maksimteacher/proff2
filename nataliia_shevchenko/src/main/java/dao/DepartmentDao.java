package dao;

import java.util.List;

import domain.Department;

public interface DepartmentDao {
	Long create(Department department);
	Department read(Long idDepart);
    void update(Department department);
    void delete(Department department);
    List<Department> findAll();
    List<Department> findAllDepartmentsForSchool(Long idDepart);

}
