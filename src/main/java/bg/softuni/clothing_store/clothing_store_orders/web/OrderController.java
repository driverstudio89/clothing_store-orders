package bg.softuni.clothing_store.clothing_store_orders.web;

import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.OrderDto;
import bg.softuni.clothing_store.clothing_store_orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/administration/orders/add-order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        LOGGER.info("going to create an offer: {}", addOrderDto);
        orderService.createOrder(addOrderDto);
        return ResponseEntity.ok().build();
    }
}
