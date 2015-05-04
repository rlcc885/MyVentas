package hbm.dao;

import hbm.HibernateConnection;
import hbm.dto.Customer;
import hbm.dto.Product;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ProductManager {
	public static Product getProduct(Integer id){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		session.getTransaction().commit();
		session.close();
		return product;
	}
	
	public static List<Product> getProducts(){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> products = (List<Product>) query.list();
		session.getTransaction().commit();
		session.close();
		return products;
	}
	
	public static void addProduct(Product product){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateProduct(Product product){
		Session session = HibernateConnection.getSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
	}
}
