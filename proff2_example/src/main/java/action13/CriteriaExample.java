package action13;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.Product;
import util.HibernateUtil;

public class CriteriaExample {
	private static final Logger LOGGER = Logger.getLogger(CriteriaExample.class);

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("******  example 1  *******************");
		Criteria crit = session.createCriteria(Product.class);
		List<?> list1 = crit.setMaxResults(10)
				.setFirstResult(2)
				.list();
		list1.forEach(product->System.out.println(product));
		System.out.println("******  example 2  *******************");
		Long countRow = (Long)session.createCriteria(Product.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		System.out.println("countRow="+countRow);
		System.out.println("******  example 3  *******************");
		List<?> list3 =  session.createCriteria(Product.class)
         	.add(Restrictions.gt("id", 3L)) // >
         	.add(Restrictions.ge("id", 8L)) // >=
         	.add(Restrictions.le("id", 12L))// <=
         	.addOrder(Order.desc("name"))// asc desc
         	.list();
		 list3.forEach(product->System.out.println(product));
		 System.out.println("******  example 4  *******************");
		 List<?> list4 =  session.createCriteria(Product.class)
				 	.add(Restrictions.or(
				 			Restrictions.eq("id", 3L),
				 			Restrictions.eq("id", 8L)
				 		))
		         	.list();
		list4.forEach(product->System.out.println(product));
		 System.out.println("******  example 5  *******************");
		 List<?> list5 =session.createCriteria(Product.class)
                    .add(Restrictions.like("name", "%u%"))
                    .list();
		 list5.forEach(product->System.out.println(product));
		 
		if(session!=null){
			session.close();
		}
		HibernateUtil.getSessionFactory().close();
	}

}
