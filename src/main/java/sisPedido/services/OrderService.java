package sisPedido.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sisPedido.entities.Order;
import sisPedido.repositories.OrderRepository;

/**Project: sisPedido
 * File: UserService.java
 * @author jaime
 * Em 31-07-2020 **/

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	// Get All
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	// Get By ID
	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
}
