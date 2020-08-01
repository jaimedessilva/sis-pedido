package sisPedido.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sisPedido.entities.Product;
import sisPedido.services.ProductService;

/**Project: sisPedido
 * File: ProductResources.java
 * @author jaime
 * Em 30-07-2020 **/

@RestController
@RequestMapping (value ="/products")
public class ProductResources {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findall() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
