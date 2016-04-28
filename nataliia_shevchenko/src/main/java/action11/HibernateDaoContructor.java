package action11;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import domain.Contructor;
import util.HibernateUtil;
//будет работать если расскомментировать строку из  dao.ContructorDao
public class HibernateDaoContructor {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		//ContructorDao contructorDao = new ContructorDaoImpl(factory);

		// contructorDao.create(new Contructor("Р—РєРµС€РµРЅРєРѕ"));

		//List<Contructor> contructors = contructorDao.findAll();
		//System.out.println(contructors);
		
		if(factory!=null){
			factory.close();
		}
	}
}
