package action13;

import java.util.Locale;

import dao.DepartmentDaoImpl;
import dao.LectureDaoImpl;
import dao.SchoolDaoImpl;
import dao.StudentDaoImpl;

public class CRMSchoolRunner {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
//		Long id = 1L;
//		SchoolDaoImpl sch = new SchoolDaoImpl();
//		sch.findAllUsersForEachSchool(id);
		
//		Long id1 = 1L;
//		DepartmentDaoImpl depar = new DepartmentDaoImpl();
//		depar.findAllDepartmentsForSchool(id1);
		
//		Long id2 = 1L;
//		StudentDaoImpl stud = new StudentDaoImpl();
//		stud.findAllStudentsForDepartment(id2);
		Long id = 1L;
		Long id1 = 3L;
		LectureDaoImpl lec = new LectureDaoImpl();
		//lec.findAllLecturesWhichWereIssuedForDepartment(id);
		//lec.findAllLecturesWhichWereIssuedForSchool(id);
		lec.findAllLecturesWhichWereIssuedForStudent(id1);
		
	}

}
