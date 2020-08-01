package sisPedido.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisPedido.entities.Category;
import sisPedido.repositories.CategoryRepository;

/**Project: sisPedido
 * File: CategoryService.java
 * @author jaime
 * Em 31-07-2020 **/

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	// Get All
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	// Get By ID
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}
}
