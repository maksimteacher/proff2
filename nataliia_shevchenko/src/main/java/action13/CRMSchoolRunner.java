package action13;

import java.util.Locale;

import dao.SchoolDaoImpl;

public class CRMSchoolRunner {
	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		SchoolDaoImpl sch = new SchoolDaoImpl();
		Long id = 1L;
		sch.findAllUsersForEachSchool(id);
		//System.out.println(sch);
		
	}

}
