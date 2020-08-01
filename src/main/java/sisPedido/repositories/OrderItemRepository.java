package sisPedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sisPedido.entities.OrderItem;

/**Project: sisPedido
 * File: UserRepository.java
 * @author jaime
 * Em 30-07-2020 **/

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
