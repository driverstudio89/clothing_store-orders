package bg.softuni.clothing_store.clothing_store_orders.repository;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.Order;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatusAndCreated(StatusType status, LocalDateTime created);

    List<Order> findAllByCreated(LocalDateTime created);

    List<Order> findAllByUser(long id);
}
