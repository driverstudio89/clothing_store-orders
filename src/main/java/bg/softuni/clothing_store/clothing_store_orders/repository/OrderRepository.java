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
    List<Order> findAllByCreatedIsBetweenAndStatus(LocalDateTime dayBegin, LocalDateTime dayEnd, StatusType status);

    List<Order> findAllByCreatedIsBetween(LocalDateTime dayBegin, LocalDateTime dayEnd);

    List<Order> findAllByStatus(StatusType status);

    List<Order> findAllByUser(long id);
}
