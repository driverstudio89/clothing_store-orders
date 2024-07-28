package bg.softuni.clothing_store.clothing_store_orders.service.impl;


import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.ChangeStatusDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.OrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.Order;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.OrderItem;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import bg.softuni.clothing_store.clothing_store_orders.repository.OrderItemRepository;
import bg.softuni.clothing_store.clothing_store_orders.repository.OrderRepository;
import bg.softuni.clothing_store.clothing_store_orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Override
    public void createOrder(AddOrderDto addOrderDto) {
        List<OrderItem> orderItems = addOrderDto.getOrderItemsRest();
        orderItemRepository.saveAll(orderItems);
        Order order = modelMapper.map(addOrderDto, Order.class);
        order.setOrderItemsRest(orderItems);
        order.setStatus(StatusType.NEW);
        order.setCreated(LocalDateTime.now());
        order.setModified(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders(StatusType statusType, LocalDateTime created) {
        List<Order> orders = orderRepository.findAllByStatusAndCreated(statusType, created);
        return mapOrdersToDto(orders);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return mapOrdersToDto(orders);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders(LocalDateTime created) {
        return mapOrdersToDto(orderRepository.findAllByCreated(created));
    }



    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    @Transactional
    public OrderDto findById(Long id) {
        return modelMapper.map(orderRepository.findById(id), OrderDto.class);
    }

    @Override
    public void changeStatus(Long id, ChangeStatusDto changeStatusDto) {
        Order order = orderRepository.findById(id).get();
        order.setStatus(changeStatusDto.getStatus());
        orderRepository.save(order);
        System.out.println();

    }

    @Override
    @Transactional
    public List<OrderDto> findAllByUserId(long id) {
        List<Order> orders = orderRepository.findAllByUser(id);
        return mapOrdersToDto(orders);

    }

    private List<OrderDto> mapOrdersToDto(List<Order> orders) {
        return orders.stream().map(o -> {
            return modelMapper.map(o, OrderDto.class);
        }).toList();
    }

}
