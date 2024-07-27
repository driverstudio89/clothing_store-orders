package bg.softuni.clothing_store.clothing_store_orders.repository;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
