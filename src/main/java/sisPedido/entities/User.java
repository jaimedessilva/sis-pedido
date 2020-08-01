package sisPedido.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**Project: sisPedido
 * File: User.java
 * @author jaime
 * Em 30-07-2020 **/

@Entity
@Table (name="tb_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore //Evita o Loop Infinito
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	/*
	 * Construct
	 */
	public User() {}
	/*
	 * Construct
	 */
	public User(Long id, String nome, String email, String phone, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.phone = phone;
		this.password = password;
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
	public String getNome() {
		return nome;
	}
	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Getter */
	public String getEmail() {
		return email;
	}
	/* Setter */
	public void setEmail(String email) {
		this.email = email;
	}
	/* Getter */
	public String getPhone() {
		return phone;
	}
	/* Setter */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* Getter */
	public String getPassword() {
		return password;
	}
	/* Setter */
	public void setPassword(String password) {
		this.password = password;
	}
	/* Getter */
	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User id:" + id 
				+ "\n nome:" + nome 
				+ "\n email:" + email 
				+ "\n phone:" + phone 
				+ "\n password:"+ password;
	}
}
