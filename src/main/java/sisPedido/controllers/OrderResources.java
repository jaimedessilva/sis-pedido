package sisPedido.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sisPedido.entities.Order;
import sisPedido.services.OrderService;

/**Project: sisPedido
 * File: OrderResources.java
 * @author jaime
 * Em 30-07-2020 **/

@RestController
@RequestMapping (value ="/orders")
public class OrderResources {
	
	@Autowired
	private OrderService orderService;
	
	//GetAll
	@GetMapping
	public ResponseEntity<List<Order>> findall() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	//GetById
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
