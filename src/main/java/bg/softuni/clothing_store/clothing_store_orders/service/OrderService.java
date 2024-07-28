package bg.softuni.clothing_store.clothing_store_orders.service;


import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.ChangeStatusDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.OrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


public interface OrderService {
    void createOrder(AddOrderDto addOrderDto);

    List<OrderDto> getAllOrders(StatusType statusType, LocalDateTime created);

    List<OrderDto> getAllOrders();

    @Transactional
    List<OrderDto> getAllOrders(LocalDateTime created);

    void deleteOrder(Long orderId);

    OrderDto findById(Long id);

    void changeStatus(Long id, ChangeStatusDto changeStatusDto);

    List<OrderDto> findAllByUserId(long id);
}
