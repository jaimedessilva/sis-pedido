package sisPedido.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**Project: sisPedido
 * File: Product.java
 * @author jaime
 * Em 31-07-2020 **/

@Entity
@Table (name="tb_product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category",
	joinColumns = @JoinColumn( name ="product_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	@OneToMany (mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	/*
	 * Construct
	 */
	public Product() {}

	/*
	 * Construct
	 */
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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
	public String getName() {
		return name;
	}

	/* Setter */
	public void setName(String name) {
		this.name = name;
	}

	/* Getter */
	public String getDescription() {
		return description;
	}

	/* Setter */
	public void setDescription(String description) {
		this.description = description;
	}

	/* Getter */
	public Double getPrice() {
		return price;
	}

	/* Setter */
	public void setPrice(Double price) {
		this.price = price;
	}

	/* Getter */
	public String getImgUrl() {
		return imgUrl;
	}

	/* Setter */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	/* Getter */
	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
