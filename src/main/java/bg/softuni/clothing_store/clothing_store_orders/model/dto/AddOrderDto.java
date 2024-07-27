package bg.softuni.clothing_store.clothing_store_orders.model.dto;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.OrderItem;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.DeliveryType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.PaymentType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class AddOrderDto {

    private List<OrderItem> orderItems;

    private BigDecimal total;

    private StatusType status;

    private PaymentType paymentType;

    private DeliveryType deliveryType;

    private String created;

    private String modified;

    private long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String Address;

    private String country;

    private String city;

    private String zip;

}
