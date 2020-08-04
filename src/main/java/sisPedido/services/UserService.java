package sisPedido.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import sisPedido.entities.User;
import sisPedido.repositories.UserRepository;
import sisPedido.services.exceptions.DatabaseException;
import sisPedido.services.exceptions.ResourcesNotFoundException;

/**Project: sisPedido
 * File: UserService.java
 * @author jaime
 * Em 31-07-2020 **/

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	// Get All
	public List<User> findAll() {
		return userRepository.findAll();
	}

	// Get By ID
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() ->new ResourcesNotFoundException(id));
	}
	// Insert
	public User insert (User obj) {
		return userRepository.save(obj);
	}
	//Delete
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourcesNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	//Update Prepare
	public User update (Long id, User obj) {
		try {
			User entity = userRepository.getOne(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourcesNotFoundException(id);
		}		
	}
	//Update
	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
