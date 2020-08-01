package sisPedido.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**Project: sisPedido
 * File: Payment.java
 * @author jaime
 * Em 01-08-2020 **/

@Entity
@Table (name ="tb_payment")
public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order order;
	
	/*
	 * Construct
	 */
	public Payment() {}

	/*
	 * Construct
	 */
	public Payment(Long id, Instant moment, Order order) {
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	/* Getter */
	public Long getId() {
		return id;
	}

	/* Setter */
	public void setId(Long id) {
		this.id = id;
	}

	/* Getter */
	public Instant getMoment() {
		return moment;
	}

	/* Setter */
	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	/* Getter */
	public Order getOrder() {
		return order;
	}

	/* Setter */
	public void setOrder(Order order) {
		this.order = order;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
