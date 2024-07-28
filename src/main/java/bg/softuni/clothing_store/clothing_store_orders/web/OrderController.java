package bg.softuni.clothing_store.clothing_store_orders.web;

import bg.softuni.clothing_store.clothing_store_orders.model.dto.AddOrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.ChangeStatusDto;
import bg.softuni.clothing_store.clothing_store_orders.model.dto.OrderDto;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import bg.softuni.clothing_store.clothing_store_orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;


    @GetMapping("/administration/orders/all-orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(
                orderService.getAllOrders()
        );
    }

//    @GetMapping("/all-orders")
//    public ResponseEntity<List<OrderDto>> getAllOrders(LocalDate created) {
//        return ResponseEntity.ok(
//                orderService.getAllOrders()
//        );
//    }

    @PostMapping("/administration/orders/add-order")
    public ResponseEntity<OrderDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        LOGGER.info("going to create an offer: {}", addOrderDto);
        orderService.createOrder(addOrderDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/administration/orders/order-{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/users/orders")
    public ResponseEntity<List<OrderDto>> viewUsersOrders(@RequestParam Long userId) {
        List<OrderDto> allByUserId = orderService.findAllByUserId(userId);
        return ResponseEntity.ok(allByUserId);
    }



    @PostMapping("/administration/orders/{id}")
    public ResponseEntity<OrderDto> changeStatusToProcessing(
            @PathVariable Long id,
            @RequestBody ChangeStatusDto changeStatusDto) {
        orderService.changeStatus(id, changeStatusDto);
        return ResponseEntity
                .ok().build();
    }


    @DeleteMapping("/administration/orders/{id}")
    public ResponseEntity<OrderDto> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
