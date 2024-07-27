package bg.softuni.clothing_store.clothing_store_orders.service;


import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;


public interface OrderService {
    void createOrder(AddOrderDto addOrderDto);

}
