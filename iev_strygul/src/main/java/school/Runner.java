package school;

import java.util.List;

import domain.School;
import service.SchoolService;
import service.SchoolServiceImpl;

public class Runner {

	public static void main(String[] args) {
		SchoolServiceImpl schoolService = new SchoolServiceImpl();
		List<School> schools = schoolService.getAllSchools();
		
		for(School schl : schools) {
			System.out.println(schl.getName());
		}

	}

}
