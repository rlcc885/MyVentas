package hbm.dto;

// Generated 18/05/2015 10:23:33 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderId generated by hbm2java
 */
@Embeddable
public class OrderId implements java.io.Serializable {

	private int id;
	private int idProduct;
	private int idCustomer;

	public OrderId() {
	}

	public OrderId(int id, int idProduct, int idCustomer) {
		this.id = id;
		this.idProduct = idProduct;
		this.idCustomer = idCustomer;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "id_product", nullable = false)
	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	@Column(name = "id_customer", nullable = false)
	public int getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderId))
			return false;
		OrderId castOther = (OrderId) other;

		return (this.getId() == castOther.getId())
				&& (this.getIdProduct() == castOther.getIdProduct())
				&& (this.getIdCustomer() == castOther.getIdCustomer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getIdProduct();
		result = 37 * result + this.getIdCustomer();
		return result;
	}

}
