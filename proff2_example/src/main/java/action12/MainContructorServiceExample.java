package action12;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorService;
import service.ContructorServiceImpl;
import util.HibernateUtil;

public class MainContructorServiceExample {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		ContructorDao contructorDao = new ContructorDaoImpl(factory);
		ContructorService contructorService = new ContructorServiceImpl(contructorDao);

		List<Contructor> contructors = contructorService.getAllContructors();
		System.out.println(contructors);

		if (factory != null) {
			factory.close();
		}
	}
}
