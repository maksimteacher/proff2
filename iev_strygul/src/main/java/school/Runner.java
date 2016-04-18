package school;

import domain.Department;
import domain.School;
import domain.Student;
import service.DepartmentServiceImpl;
import service.SchoolServiceImpl;
import service.StudentServiceImpl;

public class Runner {

	public static void main(String[] args) {
		SchoolServiceImpl schoolService = new SchoolServiceImpl();
		DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
		StudentServiceImpl studentService = new StudentServiceImpl();
		
/*		for(int i = 0; i < 3; i++) {
			School school = new School();
			school.setName("School#" + i);
			schoolService.addSchool(school);
			for(int j = 0; j < 3; j++) {
				Department dep = new Department();
				dep.setName("Department#" + i + j);
				dep.setSchool(school);
				departmentService.addDepartment(dep);
				for(int y = 0; y < 3; y++) {
					Student st = new Student();
					st.setName("Student#" + i + j + y);
					st.setLogin("Login#" + st.getName());
					st.setPass("Pass#" + st.getName());
					st.setDep(dep);
					studentService.addStudent(st);
				}
			}
		}
*/
		
		
		System.out.println(departmentService.getAllDepartmentsForSchool(Long.parseLong("5")));
		System.out.println(studentService.getAllStudentsByDep(Long.parseLong("2")));
		System.out.println(studentService.getAllStudFromSchoolSortedByName(new Long(6)));

	}

}
