package bg.softuni.clothing_store.clothing_store_orders.service;


import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.ChangeStatusDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.OrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface OrderService {
    void createOrder(AddOrderDto addOrderDto);

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrders(LocalDate created);

    List<OrderDto> getAllOrders(StatusType statusType);

    List<OrderDto> getAllOrders(LocalDate created, StatusType statusType);

    void deleteOrder(Long orderId);

    OrderDto findById(Long id);

    void changeStatus(Long id, ChangeStatusDto changeStatusDto);

    List<OrderDto> findAllByUserId(long id);
}
