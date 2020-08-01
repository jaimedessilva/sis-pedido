package sisPedido.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sisPedido.entities.User;
import sisPedido.services.UserService;

/**Project: sisPedido
 * File: UserResources.java
 * @author jaime
 * Em 30-07-2020 **/

@RestController
@RequestMapping (value ="/users")
public class UserResources {
	
	@Autowired
	private UserService userService;
	//FindAll
	@GetMapping
	public ResponseEntity<List<User>> findall() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	//FindById
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	//Insert
	@PostMapping
	public ResponseEntity<User> insert (@RequestBody User obj){
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj
				.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	//Delete
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	//Update
	@PutMapping(value ="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
