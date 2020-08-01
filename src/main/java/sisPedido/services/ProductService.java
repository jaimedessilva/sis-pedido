package sisPedido.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisPedido.entities.Product;
import sisPedido.repositories.ProductRepository;

/**Project: sisPedido
 * File: ProductService.java
 * @author jaime
 * Em 31-07-2020 **/

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	// Get All
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	// Get By ID
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
}
