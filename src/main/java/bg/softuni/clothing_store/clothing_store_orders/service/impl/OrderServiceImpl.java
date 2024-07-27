package bg.softuni.clothing_store.clothing_store_orders.service.impl;


import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.Order;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.OrderItem;
import bg.softuni.clothing_store.clothing_store_orders.repository.OrderItemRepository;
import bg.softuni.clothing_store.clothing_store_orders.repository.OrderRepository;
import bg.softuni.clothing_store.clothing_store_orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void createOrder(AddOrderDto addOrderDto) {
        List<OrderItem> orderItems = addOrderDto.getOrderItems();
        orderItemRepository.saveAll(orderItems);
        Order order = modelMapper.map(addOrderDto, Order.class);
        order.setOrderItems(orderItems);
        orderRepository.save(order);
    }

}
