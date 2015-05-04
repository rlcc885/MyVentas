package hbm.dao;

import hbm.HibernateConnection;
import hbm.dto.Order;
import hbm.dto.OrderId;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class OrderManager {
	public static Order getOrder(OrderId id){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Order order = (Order) session.get(Order.class, id);
		session.getTransaction().commit();
		session.close();
		return order;
	}
	
	public static List<Order> getOrders(){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Order");
		List<Order> order = (List<Order>) query.list();
		session.getTransaction().commit();
		session.close();
		return order;
	}
	
	public static Order addOrder(Order order){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
		return order;
	}
	
	public static Order updateOrder(Order order){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		return order;
	}
}
