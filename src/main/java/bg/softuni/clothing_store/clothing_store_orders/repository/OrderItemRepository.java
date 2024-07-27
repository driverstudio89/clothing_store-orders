package bg.softuni.clothing_store.clothing_store_orders.repository;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
