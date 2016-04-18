package school;

import java.util.ArrayList;
import java.util.List;

import dao.LectureDaoImpl;
import dao.LessonDaoImpl;
import domain.Department;
import domain.Lecture;
import domain.Lesson;
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
		List<Lecture> lectures = new ArrayList<>();
		List<Department> departments = departmentService.getAllDepartments();
		
		LectureDaoImpl lectureDao = new LectureDaoImpl();
		LessonDaoImpl lessonDao = new LessonDaoImpl();
		
		for(int i = 0; i < 3; i++) {
			Lesson lesson = new Lesson();
			lesson.setName("Lesson#" + i);
			lesson.setLecture(lectureDao.read(new Long(1)));
			lessonDao.create(lesson);
		}
		
		
		

	}

}
