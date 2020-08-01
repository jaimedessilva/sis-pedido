package sisPedido.entities.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sisPedido.entities.Order;
import sisPedido.entities.Product;

/**Project: sisPedido
 * File: OrderItemPk.java
 * @author jaime
 * Em 31-07-2020 **/

@Embeddable
public class OrderItemPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Product product;
	
	/* Getter */
	public Order getOrder() {
		return order;
	}
	/* Setter */
	public void setOrder(Order order) {
		this.order = order;
	}
	/* Getter */
	public Product getProduct() {
		return product;
	}
	/* Setter */
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPk other = (OrderItemPk) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
}
