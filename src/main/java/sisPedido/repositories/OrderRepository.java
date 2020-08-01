package sisPedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisPedido.entities.Order;

/**Project: sisPedido
 * File: UserRepository.java
 * @author jaime
 * Em 30-07-2020 **/

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
