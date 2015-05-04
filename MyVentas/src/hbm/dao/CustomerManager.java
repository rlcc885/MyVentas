package hbm.dao;

import java.util.List;

import hbm.HibernateConnection;
import hbm.dto.Customer;

import org.hibernate.Query;
import org.hibernate.Session;

public class CustomerManager {
	public static Customer getCustomer(Integer id){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.getTransaction().commit();
		session.close();
		return customer;
	}
	
	public static List<Customer> getCustomers(){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> customers = (List<Customer>) query.list();
		session.getTransaction().commit();
		session.close();
		return customers;
	}
	
	public static void addCustomer(Customer customer){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateCustomer(Customer customer){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();
		session.close();
	}
}
