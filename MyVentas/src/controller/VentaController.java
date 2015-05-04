package controller;

import hbm.dao.CustomerManager;
import hbm.dao.DebtManager;
import hbm.dao.OrderManager;
import hbm.dao.ProductManager;
import hbm.dto.Customer;
import hbm.dto.DebtDetailByCustomer;
import hbm.dto.Order;
import hbm.dto.OrderId;
import hbm.dto.Product;

import java.util.Date;
import java.util.List;


public class VentaController {
	public static List<Product> getProducts(){
		return ProductManager.getProducts();
	}
	
	public static Product getProduct(Integer id){
		return ProductManager.getProduct(id);
	}
	
	public static List<Customer> getCustomers(){
		return CustomerManager.getCustomers();
	}
	
	public static Customer getCustomer(Integer id){
		return CustomerManager.getCustomer(id);
	}
	
	public static String addSale(Integer idCliente, Integer idProducto, Double precio, Integer cantidad, String comentario){
		Customer customer = getCustomer(idCliente);
		Product product = getProduct(idProducto);
		
		OrderId orderId = new OrderId();
		orderId.setIdCustomer(customer.getId());
		orderId.setIdProduct(product.getId());
		double fullPrice = precio*cantidad;
		Order order = new Order(orderId, product, customer, cantidad, precio, fullPrice, new Date(), 0, comentario);
		order.setId(orderId);
		order = OrderManager.addOrder(order);
		return ""+order.getQuantity() + " " + product.getName() + " comprado por " + customer.getName() + " a las "+ order.getOrderDate();
	}
	
	public static List<DebtDetailByCustomer> getDebByCustomer(Integer idCustomer){
		return DebtManager.getDebtByCustomer(idCustomer);
	}
}
