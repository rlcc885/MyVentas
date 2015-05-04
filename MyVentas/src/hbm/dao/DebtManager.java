package hbm.dao;

import hbm.HibernateConnection;
import hbm.dto.DebtDetailByCustomer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class DebtManager {
	public static List<DebtDetailByCustomer> getDebtByCustomer(Integer idCustomer){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from DebtDetailByCustomer where id_customer = "+idCustomer);
		List<DebtDetailByCustomer> list = (List<DebtDetailByCustomer>)query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
