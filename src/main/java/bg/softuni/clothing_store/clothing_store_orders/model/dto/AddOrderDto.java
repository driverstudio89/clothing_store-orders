package bg.softuni.clothing_store.clothing_store_orders.model.dto;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.OrderItem;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.DeliveryType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.PaymentType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class AddOrderDto {

    private List<OrderItem> orderItemsRest;

    private BigDecimal total;

    private PaymentType paymentType;

    private DeliveryType deliveryType;

//    private LocalDateTime created;
//
//    private LocalDateTime modified;

    private Long user;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String Address;

    private String country;

    private String city;

    private String zip;

}
