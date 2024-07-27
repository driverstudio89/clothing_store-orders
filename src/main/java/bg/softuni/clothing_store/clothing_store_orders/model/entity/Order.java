package bg.softuni.clothing_store.clothing_store_orders.model.entity;

import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.DeliveryType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.PaymentType;
import bg.softuni.clothing_store.clothing_store_orders.model.entity.enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = OrderItem.class)
    private List<OrderItem> orderItems;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private String Address;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @Column(nullable = false)
    private String created;

    @Column(nullable = false)
    private String modified;

    @Column
    private long userId;

    public Order() {
        this.orderItems = new ArrayList<>();
    }


}
