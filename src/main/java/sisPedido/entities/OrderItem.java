package sisPedido.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sisPedido.entities.pk.OrderItemPk;

/**Project: sisPedido
 * File: OrderItem.java
 * @author jaime
 * Em 31-07-2020 **/

@Entity
@Table (name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	private Integer quantity;
	private Double price;
	/*
	 * Construct
	 */
	public OrderItem() {}
	/*
	 * Construct
	 */
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	/*Getter*/
	@JsonIgnore
	public Order getOrder () {
		return id.getOrder();
	}
	/*Setter*/
	public void setOrder (Order order) {
		id.setOrder(order);
	}
	/*Getter*/
	public Product getProduct () {
		return id.getProduct();
	}
	/*Setter*/
	public void setProduct (Product product) {
		id.setProduct(product);
	}
	
	/* Getter */
	public Integer getQuantity() {
		return quantity;
	}
	/* Setter */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/* Getter */
	public Double getPrice() {
		return price;
	}
	/* Setter */
	public void setPrice(Double price) {
		this.price = price;
	}
	/* Sub total */
	public Double getSubTotal () {
		return price * quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
