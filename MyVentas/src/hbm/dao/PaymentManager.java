package hbm.dao;

import hbm.HibernateConnection;
import hbm.dto.Payment;
import hbm.dto.PaymentId;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PaymentManager {
	public Payment getPayment(PaymentId id){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Payment payment = (Payment) session.get(PaymentId.class, id);
		session.getTransaction().commit();
		session.close();
		return payment;
	}
	
	public List<Payment> getPayments(){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Payment");
		List<Payment> payment = (List<Payment>) query.list();
		session.getTransaction().commit();
		session.close();
		return payment;
	}
	
	public void addPayment(Payment payment){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updatePayment(Payment payment){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.update(payment);
		session.getTransaction().commit();
		session.close();
	}
}
